package by.tms.storage;

import by.tms.domain.Student;

import java.sql.*;

public class StudentStorage {

	public Student updateStudentById (long id , Student student) {
		Connection connection = null;
		String login = null;
		String password = null;
		String name = null;
		String faculty = null;
		String group = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
			PreparedStatement preparedStatement = connection.prepareStatement("update studentbase set login = ?, password = ?, name = ?, faculty = ?, groupa = ? where id = ?");
			preparedStatement.setString(1, student.getLogin());
			preparedStatement.setString(2, student.getPassword());
			preparedStatement.setString(3, student.getPassword());
			preparedStatement.setString(4, student.getFaculty());
			preparedStatement.setString(5, student.getGroup());
			preparedStatement.setLong(6, id);
			preparedStatement.executeUpdate();
			PreparedStatement preparedStatement1 = connection.prepareStatement("select * from studentbase u where u.id = ?");
			preparedStatement1.setLong(1, id);
			ResultSet resultSet = preparedStatement1.executeQuery();
			resultSet.next();
			login = resultSet.getString(2);
			password = resultSet.getString(3);
			name = resultSet.getString(4);
			faculty = resultSet.getString(5);
			group = resultSet.getString(6);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Student(id, login, password, name, faculty, group);
	}

	public boolean updatePasswordById (long id , String password) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
			PreparedStatement preparedStatement = connection.prepareStatement("update studentbase set password = ? where id = ?");
			preparedStatement.setString(1, password);
			preparedStatement.setLong(2, id);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean updateNameById (long id , String name) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
			PreparedStatement preparedStatement = connection.prepareStatement("update studentbase set name = ? where id = ?");
			preparedStatement.setString(1, name);
			preparedStatement.setLong(2, id);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean updateFacultyById (long id , String faculty) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
			PreparedStatement preparedStatement = connection.prepareStatement("update studentbase set faculty = ? where id = ?");
			preparedStatement.setString(1, faculty);
			preparedStatement.setLong(2, id);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean updateGroupById (long id , String groupa) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
			PreparedStatement preparedStatement = connection.prepareStatement("update studentbase set groupa = ? where id = ?");
			preparedStatement.setString(1, groupa);
			preparedStatement.setLong(2, id);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
}
