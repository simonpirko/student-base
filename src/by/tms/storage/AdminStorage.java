package by.tms.storage;

import java.sql.*;

public class AdminStorage {

    Connection connection = null;

    public void save (String login, String name, String password, String role) {

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgress", "learn2000_");
            PreparedStatement preparedStatement = connection.prepareStatement("update admins set id = default login = ?, password = ?, name = ?, role = ?");
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

    public boolean checkByRole (String login, String password, String role) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from admins s where s.login = ?");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getString(3).equals(password) && resultSet.getString(4).equals(role) ) {
                   return true;
                }
                else return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
