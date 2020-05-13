package by.tms.storage;

import by.tms.domain.Admin;
import by.tms.domain.Student;

import java.sql.*;

public class AdminStorage {

    Connection connection = null;

    public void updatePasswordById (long id , String password) {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
            PreparedStatement preparedStatement = connection.prepareStatement("update admins set password = ? where id = ?");
            preparedStatement.setString(1, password);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePasswordByLogin (String login , String password) {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
            PreparedStatement preparedStatement = connection.prepareStatement("update admins set password = ? where login = ?");
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, login);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Admin findAdminByLogin (String login) {
        long id = 0;
        String name = null;
        String password = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
            PreparedStatement preparedStatement = connection.prepareStatement("select *from admins where login = ?");
            preparedStatement.setString(1,login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                id = resultSet.getLong(1);
                name = resultSet.getString(2);
                password = resultSet.getString(3);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Admin(id, name, password, login);
    }

    public Admin findAdminById (long id) {
        String login = null;
        String name = null;
        String password = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
            PreparedStatement preparedStatement = connection.prepareStatement("select *from admins where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                name = resultSet.getString(2);
                password = resultSet.getString(3);
                login = resultSet.getString(5);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Admin (id, name, password, login);
    }

    public long findIdByLogin (String login) {
        long id = 0;
          try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
            PreparedStatement preparedStatement = connection.prepareStatement("select *from admins where login = ?");
            preparedStatement.setString(1,login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                id = resultSet.getLong(1);
              }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
