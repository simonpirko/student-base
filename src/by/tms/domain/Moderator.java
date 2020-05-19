package by.tms.domain;

public class Moderator extends UsersOfStudentBase {

    public Moderator(long id, String name, String login, String password, String role) {
        super(id, name, login, password, role);
    }

    public Moderator(String name, String login, String password, String role) {
        super(name, login, password, role);
    }

    @Override
    public String toString() {
        return "Moderator{}";
    }
}