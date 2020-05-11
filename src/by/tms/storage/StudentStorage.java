package by.tms.storage;

import by.tms.domain.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentStorage {

	public Student getStudentById(Long id){

		String name = null;
		String login1 = null;
		String password = "secret password";
		String faculty = null;
		String group = null;
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_base");
			PreparedStatement preparedStatement = connection.prepareStatement("select *from students where id = ?");
			preparedStatement.setLong(1,id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				name = resultSet.getString(2);
				login1 = resultSet.getString(3);
				faculty = resultSet.getString(5);
				group = resultSet.getString(6);
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Student student = new Student(id,name,login1,password,faculty,group);
		return student;
	}

	public Student getStudentByLogin(String login){

		int id = 0;
		String name = null;
		String login1 = null;
		String password = "secret password";
		String faculty = null;
		String group = null;
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_base");
			PreparedStatement preparedStatement = connection.prepareStatement("select *from students where login = ?");
			preparedStatement.setString(1,login);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				id = resultSet.getInt(1);
				name = resultSet.getString(2);
				login1 = resultSet.getString(3);
				faculty = resultSet.getString(5);
				group = resultSet.getString(6);
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Student student = new Student(id,name,login1,password,faculty,group);
		return student;
	}

	public List<Student> getAll(){

		List<Student> students = new ArrayList<>();

		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_base");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select *from students");
			while (resultSet.next()){
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String login = resultSet.getString(3);
				String password = resultSet.getString(4);
				String faculty = resultSet.getString(5);
				String group = resultSet.getString(6);
				Student student = new Student(id,name, login, password, faculty, group);
				students.add(student);
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
}
