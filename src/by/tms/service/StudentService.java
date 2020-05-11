package by.tms.service;

import by.tms.domain.Student;
import by.tms.storage.StudentStorage;

public class StudentService {
    private StudentStorage studentStorage = new StudentStorage();


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
