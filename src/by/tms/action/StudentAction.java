package by.tms.action;

import by.tms.domain.Student;
import by.tms.service.StudentService;
import by.tms.storage.StudentStorage;

import java.util.Scanner;

public class StudentAction {
	private StudentService studentService = new StudentService();
	StudentStorage studentStorage = new StudentStorage();

	public static void main(String[] args) {
		StudentAction studentAction = new StudentAction();
		studentAction.star();
	}

    public void star() {
        boolean b = true;
        while (b) {
            StudentAction.write("1 - Administrator / 2 - Student");
            switch ((int) StudentAction.readDouble()) {
                case 1:
                    startAdministration();
                    break;
                case 2:
                    b = starStudent();
                    break;
             }
        }
    }

	private boolean starStudent() {
		boolean b = true;
		while (b) {
			StudentAction.write("1 - Registration / 2 - Authorise / 3 - Exit");
			switch ((int) StudentAction.readDouble()) {
				case 1:
					registration();
					break;
				case 2:
					long id  = authTablesId();
					if (id > 0){
					    actionBeforeAuthorisation(id);
                    }
					break;
				case 3:
					b = false;
					StudentAction.write("Goodbye");
					return false;
			}
		}
		return true;
	}

	public void actionBeforeAuthorisation( long id ) {
		while (true) {
			StudentAction.write("1 - You profile / 2 - Update profile / 3 - Return");
			switch ((int) StudentAction.readDouble()) {
				case 1:
					studentStorage.getStudentById ( id );
					break;
				case 2:
					updateProfile(id);
					break;
				case 3:
					return ;
			}
		}
	}

	public void updateProfile ( long id ) {
		while (true) {
			StudentAction.write("1 - Update password / 2 - Update name / 2 - Update name / 3 - Update faculty /2 - Update group");
			switch ((int) StudentAction.readDouble()) {
				case 1:
					registration();
					break;
				case 2:
//					authorization();
					break;
				case 3:
					return ;
				case -100:
					StudentAction.write("Error");
					break;
			}
		}
	}
	public void startAdministration() {
		while (true) {
			StudentAction.write("1 - Find all user / 2 - Remove user / 3 - Update user / 4 - Exit");
			switch ((int) StudentAction.readDouble()) {
				case 1:
					registration();
					break;
				case 2:
//					authorization();
					break;
				case 3:
					return ;
				case -100:
					StudentAction.write("Error");
					break;
			}
		}
	}

	public void registration() { }

	public long authTablesId() {
		long id;
		StudentStorage studentStorage = new StudentStorage();
		System.out.println(" Enter Name ");
		String loginName = StudentAction.readLine();
		id = studentStorage.returnIdByLogin(loginName);
		Student student = studentStorage.getStudentById(id);
		if (id != 0){
			StudentAction.write (" Enter Password");
			String loginPassword = StudentAction.readLine();
			if (loginPassword.equals(student.getPassword())) {
				StudentAction.write("Hello " + loginName);
			} else {
				StudentAction.write("Incorrect password");
			}
		}
		return id = student.getId();
	}



		public static double readDouble() { // метод использовать там, где нужны только цифры
			Scanner scanner = new Scanner(System.in);
			double number;
			do {
				while (!scanner.hasNextDouble()) {
					StudentAction.write("A string or character, or empty string was entered, try again");
					scanner.nextLine();
				}
				number = scanner.nextDouble();
				if (number < 0) StudentAction.write("A negative number was entered, try again");
			}
			while (number < 0);
			return number;
		}


			public static void write(Object message) {
				System.out.println(message);
			}

    public static int readerInt(){
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        else return -100;
    }
    public static String readLine(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
	}
