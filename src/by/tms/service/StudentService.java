package by.tms.service;

import by.tms.action.util.Writer;
import by.tms.domain.Student;
import by.tms.storage.StudentStorage;

//public class StudentService {
//	private StudentStorage studentStorage = new StudentStorage();
//
//	public boolean add(String name,
//					   String login,
//					   String password,
//					   String faculty,
//					   String group) {
//		if (!(studentStorage.existLogin())) {
//			Student student = new Student(name, login, password, faculty, group);
//			student.setLogin(student.getLogin().toUpperCase());
//			studentStorage.save(student);
//			return true;
//		} else {
//			Writer.write("Ошибка добавления, такой студент уже существует");
//			return false;
//		}
//	}
//
//	public boolean remove(Student loign) { //По существующему логигу
//		if (studentStorage.existLogin(student.getLogin())) {
//			studentStorage.remove();
//			return true;
//		} else {
//			Writer.write("Таких студентов не найдено");
//			return false;
//		}
//	}
//
//	public Student searchByLogin(String login) {
//		if (studentStorage.existLogin(login)) {
//			return studentStorage.getStudent();
//		} else {
//			Writer.write("Студентов с таким логином не сущесвует");
//		}
//		return null;
//	}
//
//	public boolean changePassword(Student student) {
//		if (studentStorage.existLogin(student.getLogin())) {
//			studentStorage.changePassword(student.getLogin()); // if(oldpassword.equals(student.getPassword()))
//			return true;
//		}
//		return false;
//	}
//
//	public boolean getStudentGroupList(Student student) {
//		if (studentStorage.existGroup(student.getGroup())) {
//			studentStorage.getGroupList();
//			return true;
//		} else {
//			Writer.write("Группа не найдена");
//		}
//		return false;
//	}
//
//	public boolean getFacultyList(String faculty) {
//		if (studentStorage.existFaculty(faculty)) {
//			studentStorage.getFacultyList();
//			return true;
//		} else {
//			Writer.write("Факультет не найден");
//		}
//		return false;
//	}
//
//	public boolean chageFaculty(Student student, String faculty) {
//		if (studentStorage.existFaculty(student.getFaculty())) {
//			studentStorage.changeFaculty;
//			return true;
//		}
//		else{
//			Writer.write("Такого факультета не существует");
//		}
//		return false;
//	}
//
//}
