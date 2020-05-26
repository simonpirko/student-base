package by.tms.action;

import by.tms.action.util.Reader;
import by.tms.action.util.Writer;
import by.tms.domain.Student;
import by.tms.service.StudentService;

import java.util.ArrayList;
import java.util.List;

import static by.tms.action.util.Reader.readId;
import static by.tms.action.util.Reader.readWithInvite;
import static by.tms.action.util.Writer.writeln;

public class StudentAction {

	private final StudentService studentService = new StudentService();

	public void addStudent() {
		String name = readWithInvite("Введите имя:");
		String login = readWithInvite("Введите логин:");
		String password = readWithInvite("Введите пароль:");
		String faculty = readWithInvite("Введите факультет:");
		String group = readWithInvite("Введите группу:");
		long role = 3;
		if (studentService.add(name, login, password, faculty, group, role)) {
			Writer.write("Студент " + login + " добавлен.");
		} else {
			Writer.write("Ошибка добавления, такой студент уже существует");
		}
	}

	public void changeStudentPasswordByLogin() {
		String login = readWithInvite("Input Login");
		String password = readWithInvite("Input password");
		if (studentService.changeStudentPasswordByLogin(login, password)) {
			writeln("Password changed");
		} else
			writeln("Error.");
	}

	public void removeStudent() {
		String login = readWithInvite("Input student Login: ");
		if (studentService.removeStudentByLogin(login))
			writeln("Student was successfully removed!");
		else
			writeln("Student with Login(" + login + ") not found OR password is incorrect!");
	}

	public void findAllStudents() {
		writeln("-= List of ALL students =-");
		List<Student> students = studentService.getAllStudents();
		for (int i = 0; i < students.size(); i++) {
			writeln(students.get(i));
		}
	}

	public void findByLogin() {
		String login = readWithInvite("Input Login: ");
		Student student = studentService.searchStudentByLogin(login);
		if (student != null)
			writeln("Founded Student with login:" + login + " :\n" + student.toString());
		else
			writeln("Student with Login(" + login + ") not found!");
	}

	public void updateNameFacultyGroupById() {
		writeln("Input student's Id:");
		long id = readId();
		if (studentService.searchById(id)) {
			String newName = readWithInvite("Input new name:");
			String newFaculty = readWithInvite("Input new faculty:");
			String newGroup = readWithInvite("Input new group:");
			String password = readWithInvite("Input Student password:");
			studentService.updateNameFacultyGroupById(id, password, newName, newFaculty, newGroup);
			writeln("Name, faculty, group were updated.");
		} else
			writeln("Student with such ID not found!");
	}

	public void updateStudentNameById() {
		writeln("Input student's Id:");
		long id = readId();
		if (studentService.searchById(id)) {
			String newName = readWithInvite("Input new name:");
			studentService.updateNameById(id, newName);
			writeln("Name, faculty, group were updated.");
		}
		writeln("Id was not found");
	}

	public void updatePasswordById() {
		writeln("Input id:");
		long id = readId();
		if (studentService.searchById(id)) {
			String newPassword = readWithInvite("Input new password:");
			studentService.changePasswordById(id, newPassword);
			writeln("Input new password:");
		}
		writeln("Student with such ID not found!");
	}

	public void updateFacultyById() {
		writeln("Input id:");
		long id = readId();
		if (studentService.updateFacultyById(id, readWithInvite("Input new faculty:")))
			writeln("Faculty updated");
		else writeln("Not found id");
	}

	public void updateGroupById() {
		writeln("Input id:");
		long id = readId();
		if (studentService.updateGroupById(id, readWithInvite("Input new group:")))
			writeln("Group updated");
		else writeln("Not found id");
	}

	public void removeByLogin() {
		Writer.write("Введите логин для удаления:");
		String login = Reader.readLine();
		if (studentService.removeStudentByLogin(login)) {
			Writer.write("Студент " + login + " удален");
		} else {
			Writer.write("Таких студентов не найдено");
		}
	}

	public void searchByLogin() {
		String login = readWithInvite("Введите логин для поиска по логину:");
		Student studentByLogin = studentService.searchStudentByLogin(login);
		if (studentByLogin != null) {
			Writer.write("Студент " + login + " найден:");
			writeln(studentByLogin.toString());
		} else {
			Writer.write("Студентов с таким логином не существует");
		}
	}

	public void changePasswordById() {
		Writer.write("Введите Id для обновления пароля:");
		Long id = readId();
		Writer.write("Введите новый пароль:");
		String newPassword = Reader.readLine();
		if (studentService.changePasswordById(id, newPassword))
			writeln("New password set");
		else writeln("Id not found");
	}

	public void getStudentGroupList() {
		String group = readWithInvite("Input group name");
		Student student;
		if (studentService.getStudentGroupList(group) != null) {
			ArrayList<Student> studentGroupList = studentService.getStudentGroupList(group);
			for (int i = 0; i < studentGroupList.size(); i++) {
				student = studentGroupList.get(i);
				writeln(student.toString());
			}
		}
	}

	public void getStudentFacultyList() {
		String faculty = readWithInvite("Input faculty name");
		Student student;
		if (studentService.getStudentFacultyList(faculty) != null) {
			ArrayList<Student> studentFacultyList = studentService.getStudentFacultyList(faculty);
			for (int i = 0; i < studentFacultyList.size(); i++) {
				student = studentFacultyList.get(i);
				writeln(student.toString());
			}
		}
	}
}
