package by.tms.service;

import by.tms.domain.Student;
import by.tms.storage.StudentStorage;

public class StudentService {
   private StudentStorage studentStorage = new StudentStorage();

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
