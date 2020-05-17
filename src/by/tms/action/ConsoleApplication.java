package by.tms.action;

import static by.tms.action.util.Reader.readLine;
import static by.tms.action.util.Reader.readMenuChoice;
import static by.tms.action.util.Writer.writeln;

public class ConsoleApplication {

    StudentAction studentAction = new StudentAction();

    public void run() {

    }

    public void menu() {

        int choice = 0;
        while (choice != 0) {
            writeln("Меню:");
            writeln("Добавить студента - 1");
            writeln("Удалить студента - 2");
            writeln("Найти студента по логину - 3");
            writeln("Изменить имя студента по Id- 4");
            writeln("Изменить пароль студента по логину - 5");
            writeln("Изменить название факультета - 6");
            writeln("Изменить название группы - 7");
            writeln("Вывести список всех студентов - 8");
            writeln("Вывести список всех студентов группы - 9");
            writeln("Вывести список все студентов факультета - 10");
            writeln("Обновить название факультета по Id- 11");
            writeln("Выход - 0");

            if ((readMenuChoice() == -1)) {
            writeln("Введите корректное значение");
            break;
            }
            else {
                switch (readMenuChoice()) {
                    case 1: studentAction.addStudent();
                    case 2: studentAction.removeByLogin();
                    case 3: studentAction.findByLogin();
                    case 4: studentAction.updateStudentNameById();
                    case 5: studentAction.changeStudentPasswordByLogin();
                    case 6: studentAction.updateFacultyById();
                    case 7: studentAction.updateGroupById();
                    case 8: studentAction.findAllStudents();
                    case 9: studentAction.getStudentGroupList();
                    case 10: studentAction.getStudentFacultyList();
                    case 11: studentAction.updateFacultyById();
                    case 0: break;
                    default:
                }
            }
        }
    }
}
