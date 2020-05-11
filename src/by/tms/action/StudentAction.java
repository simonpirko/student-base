package by.tms.action;

import by.tms.service.StudentService;
import by.tms.domain.Student;
import static by.tms.util.Reader.*;
import static by.tms.util.Writer.*;

public class StudentAction {

	private static StudentService studentService = new StudentService();

	public static void addStudent() {

		if(studentService.add(readWithInvite("Input student Name: "),
				readWithInvite("Input student Login: "),
				readWithInvite("Input student Password: "),
				readWithInvite("Input student Faculty: "),
				readWithInvite("Input student Group: ")))
			writeln("Student was successfully added!");
	}

	public static void removeStudent() {

		String login = readWithInvite("Input student Login: "),
				password = readWithInvite("Input student Password: ");

		if(studentService.remove(login, password))
			writeln("Student was successfully removed!");
		else
			writeln("Student with Login(" + login + ") not found OR password is incorrect!");
	}

	public static void findAll() {

		writeln("-= List of ALL students =-");
		for(Student student : studentService.getAllStudents())
			writeln(student);
	}

	public static void findByLogin() {

		Student student = null;
		String login = readWithInvite("Input Login: ");

		if((student = studentService.searchByLogin(login)) != null)
			writeln("Founded Student:\n" + student);
		else
			writeln("Student with Login(" + login + ") not found!");
	}

	public static void updateById() {

		Student student = null;

		if(student = getStudentById(readId()) == null) {
			writeln("Student with such ID not found!");
			return;
		}

		if(student.checkPassword(readWithInvite("Input Password: "))) {
			student.setName(readWithInvite("Input new Name: "));
			student.setFaculty(readWithInvite("Input new Faculty: "));
			student.setGroup(readWithInvite("Input new Group: "));
			if(studentService.updateStudent(student))
				writeln("Student successfully updated!");
		}
	}

	public static void updateNameById() {

		Student student = null;

		if(student = getStudentById(readId()) == null) {
			writeln("Student with such ID not found!");
			return;
		}

		if(student.checkPassword(readWithInvite("Input Password: "))) {
			student.setName(readWithInvite("Input new Name: "));
			if(studentService.updateStudent(student))
				writeln("Student successfully updated!");
		}
	}

	public static void updatePasswordById() {

		Student student = null;

		if(student = getStudentById(readId()) == null) {
			writeln("Student with such ID not found!");
			return;
		}

		if(student.checkPassword(readWithInvite("Input Password: "))) {
			String newPassword = readWithInvite("Input NEW Paword: ");
			String confPassword = readWithInvite("Input NEW Paword again: ");
			if(newPassword.equals(confPassword))
				if(studentService.updateStudent(student))
					writeln("Password successfully changed!");
		}
	}

	public static void updateFacultyById() {

		Student student = null;

		if(student = getStudentById(readId()) == null) {
			writeln("Student with such ID not found!");
			return;
		}

		if(student.checkPassword(readWithInvite("Input Password: "))) {
			student.setFaculty(readWithInvite("Input new Faculty: "));
			if(studentService.updateStudent(student))
				writeln("Student faculty successfully updated!");
		}
	}

	public static void updateGroupById() {

		Student student = null;

		if(student = getStudentById(readId()) == null) {
			writeln("Student with such ID not found!");
			return;
		}

		if(student.checkPassword(readWithInvite("Input Password: "))) {
			student.setGroup(readWithInvite("Input new Group: "));
			if(studentService.updateStudent(student))
				writeln("Student group successfully updated!");
		}
	}
}
