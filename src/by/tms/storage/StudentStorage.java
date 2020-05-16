package by.tms.storage;

import by.tms.domain.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentStorage {

	//Welcome to Slack
	Connection connection = null;

	public void saveStudent (String name, String login, String password, String faculty, String group) {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgress", "learn2000_");
			PreparedStatement preparedStatement = connection.prepareStatement("update students s set s.id = default, set s.name = ?, set s.login = ?, set s.password = ?, set s.faculty = ?, set s.group = ?");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, login);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, faculty);
			preparedStatement.setString(5, group);
			preparedStatement.executeQuery();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public long returnIdByLogin (String login) {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgress", "learn2000_");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from students s where s.login = ?");
			preparedStatement.setString(1, login);
			ResultSet resultSet = preparedStatement.executeQuery();
			long loginForReturn = resultSet.getLong(1);
			connection.close();
			return loginForReturn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public boolean removeStudentById (Long id) {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgress", "learn2000_");
			PreparedStatement preparedStatement = connection.prepareStatement("delete * from students s where s.id = ?");
			preparedStatement.setLong(1, id);
			preparedStatement.executeQuery();
			connection.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} return false;
	}

	public ArrayList<Student> getAllStudents () {
		try {
			long id = 0;
			String name = "";
			String login = "";
			String password = "";
			String faculty = "";
			String group = "";
			Student student = null;
			List<Student> listOfStudents = new  ArrayList();
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgress", "learn2000_");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from students");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				id = resultSet.getLong(1);
				name = resultSet.getString(2);
				login = resultSet.getString(3);
				password = resultSet.getString(4);
				faculty = resultSet.getString(5);
				group = resultSet.getString(6);
				student.setId(id);
				student.setName(name);
				student.setLogin(login);
				student.setFaculty(faculty);
				student.setPassword(password);
				student.setGroup(group);
				listOfStudents.add(student);
			}
			return (ArrayList<Student>) listOfStudents;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Student getStudentByLogin (String inputLogin) {
		try {
			long id = 0;
			String name = "";
			String login = "";
			String password = "";
			String faculty = "";
			String group = "";
			Student student = null;
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from students s where s.login = ?");
			preparedStatement.setString(1, inputLogin);
			ResultSet resultSet = preparedStatement.executeQuery();
			id = resultSet.getLong(1);
			name = resultSet.getString(2);
			login = resultSet.getString(3);
			password = resultSet.getString(4);
			faculty = resultSet.getString(5);
			group = resultSet.getString(6);
			student.setId(id);
			student.setName(name);
			student.setLogin(login);
			student.setFaculty(faculty);
			student.setPassword(password);
			student.setGroup(group);
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateStudentById (long id , Student student) {
			try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
			PreparedStatement preparedStatement = connection.prepareStatement("update students s set s.login = ?, s.password = ?, s.name = ?, s.faculty = ?, s.group = ? where s.id = ?");
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
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
			PreparedStatement preparedStatement = connection.prepareStatement("update students set password = ? where id = ?");
			preparedStatement.setString(1, password);
			preparedStatement.setLong(2, id);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatePasswordByLogin (String login , String newPassword) {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
			PreparedStatement preparedStatement = connection.prepareStatement("update students s set s.password = ? where s.login = ?");
			preparedStatement.setString(1, newPassword);
			preparedStatement.setString(2, login);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public void updateNameById (long id , String name) {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
			PreparedStatement preparedStatement = connection.prepareStatement("update studens set name = ? where id = ?");
			preparedStatement.setString(1, name);
			preparedStatement.setLong(2, id);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateFacultyById (long id , String faculty) {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
			PreparedStatement preparedStatement = connection.prepareStatement("update students set faculty = ? where id = ?");
			preparedStatement.setString(1, faculty);
			preparedStatement.setLong(2, id);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateGroupById (long id , String groupa) {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
			PreparedStatement preparedStatement = connection.prepareStatement("update students set groupa = ? where id = ?");
			preparedStatement.setString(1, groupa);
			preparedStatement.setLong(2, id);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean checkById(Long id) {
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

	public boolean updateNameFacultyGroupById (long id, String password, String newName, String newFaculty, String newGroup) {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgress", "learn2000_");
			PreparedStatement preparedStatement = connection.prepareStatement("update students s set s.name = ?, s.faculty = ?, s.group = ? where id = ?");
			preparedStatement.setString(1, newName);
			preparedStatement.setString(2, newFaculty);
			preparedStatement.setString(3, newGroup);
			preparedStatement.setLong(4, id);
			preparedStatement.executeQuery();
			connection.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} return false;
	}
}
