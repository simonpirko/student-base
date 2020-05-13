package by.tms.action;

import by.tms.action.util.Reader;
import by.tms.action.util.Writer;
import by.tms.domain.Student;
import by.tms.service.StudentService;
import static by.tms.action.util.Reader.*;
import static by.tms.action.util.Writer.*;

public class StudentAction {

	private StudentService studentService = new StudentService();

	public void addStudent() {

		if (studentService.add(readWithInvite("Input student Name: "),
				readWithInvite("Input student Login: "),
				readWithInvite("Input student Password: "),
				readWithInvite("Input student Faculty: "),
				readWithInvite("Input student Group: ")))
			writeln("Student was successfully added!");
	}

	public void removeStudent() {

		String login = readWithInvite("Input student Login: "),
				password = readWithInvite("Input student Password: ");

		if (studentService.remove(login, password))
			writeln("Student was successfully removed!");
		else
			writeln("Student with Login(" + login + ") not found OR password is incorrect!");
	}

	public void findAll() {

		writeln("-= List of ALL students =-");
		for (Student student : studentService.getAllStudents())
			writeln(student);
	}

	public void findByLogin() {

		Student student = null;
		String login = readWithInvite("Input Login: ");

		if ((student = studentService.searchByLogin(login)) != null)
			writeln("Founded Student:\n" + student);
		else
			writeln("Student with Login(" + login + ") not found!");
	}

	public void updateById() {

		Student student = null;

		if (student = getStudentById(readId()) == null) {
			writeln("Student with such ID not found!");
			return;
		}

		if (student.checkPassword(readWithInvite("Input Password: "))) {
			student.setName(readWithInvite("Input new Name: "));
			student.setFaculty(readWithInvite("Input new Faculty: "));
			student.setGroup(readWithInvite("Input new Group: "));
			if (studentService.updateStudent(student))
				writeln("Student successfully updated!");
		}
	}

	public void updateNameById() {

		Student student = null;

		if (student = getStudentById(readId()) == null) {
			writeln("Student with such ID not found!");
			return;
		}

		if (student.checkPassword(readWithInvite("Input Password: "))) {
			student.setName(readWithInvite("Input new Name: "));
			if (studentService.updateStudent(student))
				writeln("Student successfully updated!");
		}
	}

	public void updatePasswordById() {

		Student student = null;

		if (student = getStudentById(readId()) == null) {
			writeln("Student with such ID not found!");
			return;
		}

		if (student.checkPassword(readWithInvite("Input Password: "))) {
			String newPassword = readWithInvite("Input NEW Paword: ");
			String confPassword = readWithInvite("Input NEW Paword again: ");
			if (newPassword.equals(confPassword))
				if (studentService.updateStudent(student))
					writeln("Password successfully changed!");
		}
	}

	public void updateFacultyById() {

		Student student = null;

		if (student = getStudentById(readId()) == null) {
			writeln("Student with such ID not found!");
			return;
		}

		if (student.checkPassword(readWithInvite("Input Password: "))) {
			student.setFaculty(readWithInvite("Input new Faculty: "));
			if (studentService.updateStudent(student))
				writeln("Student faculty successfully updated!");
		}
	}

	public void updateGroupById() {

		Student student = null;

		if (student = getStudentById(readId()) == null) {
			writeln("Student with such ID not found!");
			return;
		}

		if (student.checkPassword(readWithInvite("Input Password: "))) {
			student.setGroup(readWithInvite("Input new Group: "));
			if (studentService.updateStudent(student))
				writeln("Student group successfully updated!");
		}
	}
}
