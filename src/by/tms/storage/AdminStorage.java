package by.tms.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
