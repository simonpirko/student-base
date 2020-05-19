package by.tms.action;

import static by.tms.action.util.Reader.*;
import static by.tms.action.util.Writer.writeln;

public class ConsoleApplication {

<<<<<<<<< Temporary merge branch 1
    StudentAction studentAction = new StudentAction();
    AdminAction adminAction = new AdminAction();

    public void run() {
=========
	public void run() {
>>>>>>>>> Temporary merge branch 2

	}

	public void menu() {

<<<<<<<<< Temporary merge branch 1
        int choice = 0;
        String studentLogin = "";
        String studentPassword = "";
        String adminLogin = "";
        String adminPassword = "";

        while (choice != 0) {
            writeln("Меню:");
            writeln("Авторизация - 1");
            writeln("Регистрация - 2");
            writeln("Выход - 0");
            choice = readMenuChoice();
            if ((choice == -1)) {
            writeln("Введите корректное значение");
            break;
            }
            else {
                switch (choice) {
                    case 1:
                        writeln("Авторизация студента - 1, Авторизация администратора - 2, Авторизация модератора - 3");
                        int authChoice = readMenuChoice();
                        switch (authChoice) {
                            case 1:
                                studentLogin = readWithInvite("Input student login");
                                studentPassword = readWithInvite("Input student password");
                                if (studentAction.authorizationStudent(studentLogin, studentPassword))
                                    casesForStudent();
                            case 2:
                                adminLogin = readWithInvite("Input admin login");
                                adminPassword = readWithInvite("Input admin password");
                                if (adminAction.authorizationAdmin(adminLogin, adminPassword)) {
                                    casesForAdmin();
                                }

                        }
                    case 2:
                        writeln("Регистрация студента - 1");
                        writeln("Регистрация администратора - 2");
                        writeln("Регистрация модератора - 3");
                    case 0:
                        break;
                    default:
                        writeln("Введите корректное значение");
                }
            }
        }
    }
    public void casesForStudent() {
        int studentChoice = 0;
        while (studentChoice != -1) {
            writeln("Выберите действия для студентов:");
            writeln("Изменить имя студента по Id - 1");
            writeln("Изменить пароль студента по логину - 2");
            writeln("Обратно в меню = 0");
            studentChoice = readMenuChoice();
            switch (studentChoice) {
                case 1:
                    studentAction.updateStudentNameById();
                case 2:
                    studentAction.changeStudentPasswordByLogin();
                case 0:
                    menu();
                default:
                    writeln("Некорректное значение");
            }
        studentChoice = -1;
        }
    }

    public void casesForAdmin() {
        int adminChoice = 0;
        while (adminChoice != -1) {
            writeln("Выберите действия для админов:");
            writeln("Найти студента по логину - 1");
            writeln("Изменить имя студента по Id- 2");
            writeln("Изменить пароль студента по логину - 3");
            writeln("Изменить название факультета - 4");
            writeln("Изменить название группы - 5");
            writeln("Вывести список всех студентов - 6");
            writeln("Вывести список всех студентов группы - 7");
            writeln("Вывести список все студентов факультета - 8");
            writeln("Обновить название факультета по Id- 9");
            writeln("Обратно в меню = 0");
            adminChoice = readMenuChoice();
            switch (adminChoice) {
                case 1:
                    studentAction.findByLogin();
                case 2:
                    studentAction.updateStudentNameById();
                case 3:
                    studentAction.updatePasswordById();
                case 4:
                    studentAction.updateFacultyById();
                case 5:
                    studentAction.updateGroupById();
                case 6:
                    studentAction.findAllStudents();
                case 7:
                    studentAction.getStudentGroupList();
                case 8:
                    studentAction.getStudentFacultyList();
                case 9:
                    studentAction.updateFacultyById();
                case 0:
                    menu();
                default:
                    writeln("Некорректное значение");
            }
            adminChoice = -1;
        }
    }
=========
	}
>>>>>>>>> Temporary merge branch 2
}

//                   case 1: studentAction.addStudent();
//                           case 2: studentAction.removeByLogin();
//                           case 3: studentAction.findByLogin();
//                           case 4: studentAction.updateStudentNameById();
//                           case 5: studentAction.changeStudentPasswordByLogin();
//                           case 6: studentAction.updateFacultyById();
//                           case 7: studentAction.updateGroupById();
//                           case 8: studentAction.findAllStudents();
//                           case 9: studentAction.getStudentGroupList();
//                           case 10: studentAction.getStudentFacultyList();
//                           case 11: studentAction.updateFacultyById();
//writeln("Удалить студента - 2");
//    writeln("Найти студента по логину - 3");
//    writeln("Изменить имя студента по Id- 4");
//    writeln("Изменить пароль студента по логину - 5");
//    writeln("Изменить название факультета - 6");
//    writeln("Изменить название группы - 7");
//    writeln("Вывести список всех студентов - 8");
//    writeln("Вывести список всех студентов группы - 9");
//    writeln("Вывести список все студентов факультета - 10");
//    writeln("Обновить название факультета по Id- 11");