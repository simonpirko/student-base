package by.tms.action;

import by.tms.action.util.Reader;
import by.tms.action.util.Writer;
import by.tms.domain.Student;
import by.tms.service.StudentService;
import by.tms.storage.StudentStorage;

public class StudentAction {
	private StudentService studentService = new StudentService();

	public void registration(){
		System.out.println("Enter name");
	}

	public void add () {
		Writer.write("Введите имя:");
		String name = Reader.readName();
		Writer.write("Введите логин:");
		String login = Reader.readLine();
		Writer.write("Введите пароль:");
		String password = Reader.readLine();
		Writer.write("Введите факультет:");
		String faculty = Reader.readLine();
		Writer.write("Введите группу:");
		String group = Reader.readLine();
		if (studentService.add(name, login, password, faculty, group)) {
			Writer.write("Студент " + login + " добавлен.");
		} else {
			Writer.write("Ошибка добавления, такой студент уже существует");
		}
	}

	public void remove() { // Вариант remove, где передается целый студент. Думаю, надо передавать только String
		Writer.write("Введите логин для удаления:");
		Student studentForRemove = new Student();
		String login = Reader.readLine();
		studentForRemove.setLogin(login);
		if (studentService.remove(studentForRemove)) {
			Writer.write("Студент " + login + " удален");
		}
	}

	public void remove2() {
		Writer.write("Введите логин для удаления:");
		String login = Reader.readLine();
		if (studentService.remove2(login)) {
			Writer.write("Студент " + login + " удален");
		} else {
			Writer.write("Таких студентов не найдено");
		}
	}

	public void findAll() {
		studentService.getAllStudents();
		Writer.write("Список студентов.");
	}

	public void searchByLogin() {
		Writer.write("Введите логин для поиска по логину:");
		String login = Reader.readLine();
		Student studentByLogin = studentService.searchByLogin(login);
		if (studentByLogin == null) {
			Writer.write("Студентов с таким логином не существует");
		} else {
			Writer.write("Студент " + login + " найден.");
			Writer.write(studentByLogin);
		}
	}

	public void updateById() { //  Я не понял, что должно обновляться по Id
		Writer.write("Введите ID для обновления");
		Long id = Reader.readLong();
	}

	public void updateNameById() {
		Writer.write("Введите Id для обновления имени:");
		Long id = Reader.readLong();
		studentService.updateNameById() {

		}
	}
}
