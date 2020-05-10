package by.tms.service;

import by.tms.domain.Student;
import by.tms.storage.StudentStorage;

public class StudentService {
    private StudentStorage studentStorage = new StudentStorage();

    //updateStudentById()
	//updatePasswordById()
	//updateNameById (long id , String name);
	//updateFacultyById (long id , String faculty)
	//public void updateGroupById (long id , String groupa)
	//boolean checkById(Long id);
	//checkByLogin(String login)
	//public boolean checkByStudent(Student student)
	//String getNameById(Long id)
    public boolean add(String name, String login, String password, String faculty, String group) {
        if (!(studentStorage.checkByLogin())) {
            Student student = new Student(name, login, password, faculty, group);
            student.setLogin(student.getLogin().toUpperCase());
            studentStorage.save(student);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(Student student) {
        if (studentStorage.checkByStudent(student)) {
            studentStorage.remove(student);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove2(String login) {
        if (studentStorage.checkByLogin(login)) {
            studentStorage.remove2(login);
            return true;
        } else {
            return false;
        }
    }

    public boolean getAllStudents() {
        if (!(studentStorage.isEmpty())) {
            studentStorage.printAll();
            return true;
        } else {
            return false;
        }
    }

    public Student searchByLogin(String login) {
        if (studentStorage.checkByLogin(login)) {
            return studentStorage.getByLogin(login);
        } else {
            return null;
        }
    }

    public boolean updateNameById(long id, String name) {
        if (studentStorage.checkByName(name) && studentStorage.checkById(id)) {
            studentStorage.updateNameById(id, name);
            return true;
        } else {
            return false;
        }
    }

    public boolean changePasswordById(long id, String newPassword) {
        if (studentStorage.checkById(id)) {
            studentStorage.updatePasswordById(id, newPassword);
            return true;
        } else {
            return false;
        }
    }

}
