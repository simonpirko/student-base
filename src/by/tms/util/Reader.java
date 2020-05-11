package by.tms.util;

import java.util.Scanner;

import static by.tms.util.Writer.writeln;

public class Reader {
    public static double readDouble() { // метод использовать там, где нужны только цифры
        Scanner scanner = new Scanner(System.in);
        double number;
        do {
            while (!scanner.hasNextDouble()) {
                Writer.write("A string or character, or empty string was entered, try again");
                scanner.nextLine();
            }
            number = scanner.nextDouble();
            if (number < 0) Writer.write("A negative number was entered, try again");
        }
        while (number < 0);
        return number;
    }


    public static String readName() {// метод использовать там, где требуется проверка на наличие спецсимволов
        Scanner scanner = new Scanner(System.in);
        String specialCharacters = " !#$%&'()*+,-./:;<=>?@[]^_`{|}~0123456789";
        String name = scanner.nextLine();
        String str[] = name.split("");
        for (int i = 0; i < str.length; i++) {
            while (specialCharacters.contains(str[i])) {
                Writer.write("String contains special characters or string is empty,try again!");
                scanner.nextLine();
            }
        }
        return null;
    }

    public static String readLine() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.nextLine().isEmpty()) {
            Writer.write("Was entered empty string,try again!");
        }
        return null;
    }

    public static String readWithInvite(String invite) {
        Writer.write(invite);
        return readLine();
    }

    public static long readId() {
        while (true) {
            try {
                long id = Long.parseLong(readWithInvite("Input Student ID: "));
                if (id < 0) throw new NumberFormatException();
                return id;
            } catch (NumberFormatException e) {
                writeln("Id incorrect! Try again!");
            }
        }
    }
}
