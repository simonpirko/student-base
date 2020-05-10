package by.tms.service;

import by.tms.action.util.Writer;
import by.tms.domain.Student;
import by.tms.storage.StudentStorage;

public class StudentService {
	private StudentStorage studentStorage = new StudentStorage();

	public boolean add(String name,
					   String login,
					   String password,
					   String faculty,
					   String group) {
		if (!(studentStorage.checkByLogin(name))) {
			Student student = new Student(name, login, password, faculty, group);
			student.setLogin(student.getLogin().toUpperCase());
			studentStorage.save(student);
			return true;
		} else {
			return false;
		}
	}

	public boolean remove(Student student) { //По существующему логигу
		if (studentStorage.checkByLogin(student.getLogin())) {
			studentStorage.remove();
			return true;
		} else {
			Writer.write("Таких студентов не найдено");
			return false;
		}
	}

	public boolean remove2(String login) { //По существующему логигу
		if (studentStorage.checkByLogin(login)) {
			studentStorage.remove();
			return true;
		} else {
			return false;
		}
	}

	public Student searchByLogin(String login) {
		if (studentStorage.checkByLogin(login)) {
			return studentStorage.getStudent();
		} else {
		}
		return null;
	}

	public boolean changePassword(Student student) {
		if (studentStorage.checkByLogin(student.getLogin())) {
			studentStorage.changePassword(student.getLogin()); // if(oldpassword.equals(student.getPassword()))
			return true;
		}
		return false;
	}

	public boolean changePasswordById(Long id, String newPassword) {
		if (studentStorage.checkById(id)) {
			studentStorage.updatePasswordById(id, newPassword);
			return true;
		}
		return false;
	}

	public boolean getStudentGroupList(Student student) {
		if (studentStorage.existGroup(student.getGroup())) {
			studentStorage.getGroupList();
			return true;
		} else {
			Writer.write("Группа не найдена");
		}
		return false;
	}

	public boolean getFacultyList(String faculty) {
		if (studentStorage.existFaculty(faculty)) {
			studentStorage.getFacultyList();
			return true;
		} else {
			Writer.write("Факультет не найден");
		}
		return false;
	}

	public boolean changeFaculty(Student student, String faculty) {
		if (studentStorage.existFaculty(student.getFaculty())) {
			studentStorage.changeFaculty;
			return true;
		}
		else{
			Writer.write("Такого факультета не существует");
		}
		return false;
	}

	public void getAllStudents() { // Написать метод для вывода списка всех студентов
		Writer.write("Список студентов:");
	}

	public boolean searchById (Long id) {
		if (studentStorage.checkById(id)) {
			return true;
		}
		return false;
	}

	public void updateNameById(Long id, String name) {
		if (studentStorage.checkById(id)) {
			studentStorage.updateNameById(id, name);
		}
	}
}
