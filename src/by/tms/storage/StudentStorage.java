package by.tms.storage;

import by.tms.domain.Student;

import java.sql.*;

public class StudentStorage {

	public void updateStudentById (long id , Student student) {
		Connection connection = null;
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
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatePasswordById (long id , String password) {
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
	}

	public void updateNameById (long id , String name) {
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
	}

	public void updateFacultyById (long id , String faculty) {
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
	}

	public void updateGroupById (long id , String groupa) {
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
	}
		public Student getStudentById (long id) {
		String login = null;
		String password = null;
		String name = null;
		String faculty = null;
		String group = null;
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from studentbase u where u.id = ?");
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			login = resultSet.getString(2);
			password = resultSet.getString(3);
			name = resultSet.getString(4);
			faculty = resultSet.getString(5);
			group = resultSet.getString(6);
			connection.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
			return new Student(id, login , password , name , faculty , group);
		}

	public long returnIdByLogin (String login){
		Connection connection = null;
		long id = 0;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from studentbase u where u.login = ?");
			preparedStatement.setString(1, login);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			id = resultSet.getLong(1);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
}
