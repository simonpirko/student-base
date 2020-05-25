package by.tms.storage;

import by.tms.domain.Admin;
import by.tms.domain.User;

import java.sql.*;

import static by.tms.action.util.Writer.writeln;

public class AdminStorage {
    Connection connection = null;

    private final String urlTables = "jdbc:postgresql://localhost:5432/postgres";
    private final String loginTables = "postgres";
    private final String passTables = "learn2000_";

    private final String sqlForRemoveAminByLogin = "delete * from admins a where a.login = ? and a.password = ?";
    private final String sqlForRemoveAdminById = "delete * from admins a where a.id = ? and a.password = ?";
    private final String sqlForUpdateAdminNameByLogin = "update admins a set a.name = ? where a.login = ? and a.password = ?";
    private final String sqlForUpdateAdminNameById = "update admins a set a.name = ? where a.id = ? and a.password = ?";
    private final String sqlForCheckAdminById = "select * from admins a where a.id = ? and a.password = ?";
    private final String sqlForCheckAdminByLogin = "select * from admins a where a.login = ? and a.password = ?";
    private final String sqlForCheckAdminPasswordByLogin = "select * from admins a set a.password = ? where a.login = ?";
    private final String sqlForSaveAdmin = "insert into admins values (default, ?, ?, ?, ?)";
    private final String sqlForCheckUserRole = "select * from admins a join roles r on a.role_id=r.id where a.login=?";
    private final String sqlForUpdatePasswordByLogin = "update admins set password = ? where id = ?";
    private final String sqlForUpdatePasswordById = "update admins set password = ? where login = ?";
    private final String sqlForFindAdminByLogin = "select * from admins where login = ?";

    public void saveAdmin (String name, String login, String password, long role) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(urlTables, loginTables, passTables);
            String sql = (sqlForSaveAdmin);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, password);
            preparedStatement.setLong(4, role);
            ResultSet resultSet = preparedStatement.executeQuery();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public long checkUserRole (String login) {
        try {
            connection = DriverManager.getConnection(urlTables, loginTables, passTables);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlForCheckUserRole);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                long checkRole = resultSet.getLong(5);
                connection.close();
                return checkRole;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }



    public void updatePasswordById(long id, String password) {
        try {
            connection = DriverManager.getConnection(urlTables, loginTables, passTables);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlForUpdatePasswordById);
            preparedStatement.setString(1, password);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePasswordByLogin(String login, String password) {
        try {
            connection = DriverManager.getConnection(urlTables, loginTables, passTables);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlForUpdatePasswordByLogin);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, login);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Admin findAdminByLogin(String login) {
        long id = 0;
        String name = null;
        String password = null;
        long role = 1;
        try {
            Connection connection = DriverManager.getConnection(urlTables, loginTables, passTables);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlForFindAdminByLogin);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getLong(1);
                name = resultSet.getString(2);
                password = resultSet.getString(4);
                role = resultSet.getLong(5);
            }
            connection.close();
            return (new Admin(id, name, login, password, role));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void removeAdminByLogin(String login, String password) {
        try {


            connection = DriverManager.getConnection(urlTables, loginTables, passTables);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlForRemoveAminByLogin);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeAdminById(long id, String password) {
        try {
            connection = DriverManager.getConnection(urlTables, loginTables, passTables);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlForRemoveAdminById);
            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, password);
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean updateAdminNameByLogin(String login, String password, String newNname) {
        try {
            connection = DriverManager.getConnection(urlTables, loginTables, passTables);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlForUpdateAdminNameByLogin);
            preparedStatement.setString(1, newNname);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, password);
            preparedStatement.executeQuery();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public void updateAdminNameById (long id, String password, String newName) {
        try {
            connection = DriverManager.getConnection(urlTables, loginTables, passTables);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlForUpdateAdminNameById);
            preparedStatement.setString(1, newName);
            preparedStatement.setLong(2, id);
            preparedStatement.setString(3, password);
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean checkAdminById (Long id, String password){
        try {
            connection = DriverManager.getConnection(urlTables, loginTables, passTables);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlForCheckAdminById);
            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                connection.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean checkAdminByLogin (String adminLogin, String adminPassword){
        try {
            connection = DriverManager.getConnection(urlTables, loginTables, passTables);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlForCheckAdminByLogin);
            preparedStatement.setString(1, adminLogin);
            preparedStatement.setString(2, adminPassword);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                connection.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }




    public boolean checkAdminPasswordByLogin (String inputLogin, String inputPassword) {
        try {
            connection = DriverManager.getConnection(urlTables, loginTables, passTables);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlForCheckAdminPasswordByLogin);
            preparedStatement.setString(1, inputPassword);
            preparedStatement.setString(2, inputLogin);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.getString(1).equals(inputPassword)) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}