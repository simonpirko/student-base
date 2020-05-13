package by.tms.storage;

import java.sql.*;

public class AdminStorage {
    Connection connection = null;

    public void save (String login, String name, String password, String role) {

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgress", "learn2000_");
            PreparedStatement preparedStatement = connection.prepareStatement("update admins a set a.id = default a.login = ?, a.password = ?, name = ?, role = ?");
            preparedStatement.setString(1,login);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, role);
            preparedStatement.executeQuery();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeAdminByLogin (String login, String password) {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgress", "learn2000_");
            PreparedStatement preparedStatement = connection.prepareStatement("delete * from admins a where a.login = ? and a.password = ?");
            preparedStatement.setString(1,login);
            preparedStatement.setString(2, password);
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeAdminById (long id, String password) {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgress", "learn2000_");
            PreparedStatement preparedStatement = connection.prepareStatement("delete * from admins a where a.id = ? and a.password = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.setString(2, password);
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAdminNameByLogin (String login, String password, String name) {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgress", "learn2000_");
            PreparedStatement preparedStatement = connection.prepareStatement("update admins a set a.name = ? where a.login = ? and a.password = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2,login);
            preparedStatement.setString(3, password);
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAdminNameById (long id, String password, String newName) {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgress", "learn2000_");
            PreparedStatement preparedStatement = connection.prepareStatement("update admins a set a.name = ? where a.id = ? and a.password = ?");
            preparedStatement.setString(1, newName);
            preparedStatement.setLong(2, id);
            preparedStatement.setString(3, password);
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkAdminByLogin (String login, String password) {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgress", "learn2000_");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from admins a where a.login = ?");
            preparedStatement.setString(1,login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
