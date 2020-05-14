package by.tms.domain;

public class Admin extends UsersOfStudentBase {

    private String role;


    public Admin(Long id, String name, String login, String password) {
        super(id, name, login, password);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Admin(long id, String name, String login, String password, String role) {
        super(id, name, login, password);
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Admin admin = (Admin) o;

        return role != null ? role.equals(admin.role) : admin.role == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "role='" + role + '\'' +
                '}';
    }
}




