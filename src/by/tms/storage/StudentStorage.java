package by.tms.storage;

import by.tms.action.util.Writer;
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

	public void updateGroupById (long id , String group) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
			PreparedStatement preparedStatement = connection.prepareStatement("update studentbase set groupa = ? where id = ?");
			preparedStatement.setString(1, group);
			preparedStatement.setLong(2, id);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean checkById(Long id) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_base");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from students s where s.id = ?");
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkByLogin(String login) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_base");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from students s where s.login = ?");
			preparedStatement.setString(1, login);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkByStudent(Student student) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_base");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from students s where s.id = ? or s.login = ?");
			preparedStatement.setLong(1, student.getId());
			preparedStatement.setString(2,student.getLogin());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkByFaculty(String faculty) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_base");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from students s where s.faculty = ?");
			preparedStatement.setString(1, faculty);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkByGroup(String group) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_base");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from students s where s.group = ?");
			preparedStatement.setString(1, group);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void getFacultyList() {
		Writer.write("Должен выводиться список факультетов");
	}

	public void getGroupList() {
		Writer.write("Должен выводиться список групп");
	}

	public void remove() {  // Нет метода удаления пользователя
		Writer.write("Должен удаляться студент");
	}

	public void save(Student student) {   // Нет метода сохранения пользователя
		Writer.write("Должен сохраняться cтудент");
	}

	public String getNameById(Long id) {
//		Writer.write("Должно возвращаться имя студента");
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_base");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from students s where s.id = ?");
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
