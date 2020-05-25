package by.tms.action;

import by.tms.action.util.Writer;
import by.tms.service.AdminService;

import static by.tms.action.util.Reader.readId;
import static by.tms.action.util.Reader.readWithInvite;
import static by.tms.action.util.Writer.writeln;

public class AdminAction {

    private AdminService adminService = new AdminService();

    public void addAdmin() {
        String newAdminName = readWithInvite("Input administrator's Name: "),
                newAdminLogin = readWithInvite("Input administrator's Login: "),
                newAdminPassword = readWithInvite("Input administrator's Password: ");
                String role = readWithInvite("Input Admin - 1 or Moderator - 2:");
                switch (role) {
                    case "1":
                        if (adminService.addAdmin(newAdminName, newAdminLogin, newAdminPassword, Long.parseLong(role)));
                        writeln("Administrator " + newAdminName + " was successfully added!");
                    case "2":
                        if (adminService.addAdmin(newAdminName, newAdminLogin, newAdminPassword, Long.parseLong(role)));
                        writeln("Moderator " + newAdminName + " was successfully added!");
                    default:
                }
        }


    public void removeAdmin() {
        String login = readWithInvite("Input Administrator's Login to delete: "),
                password = readWithInvite("Input Administrator's Password: ");
        if (adminService.removeAdmin(login, password))
            writeln("Student was successfully removed!");
        else
            writeln("Student with Login(" + login + ") not found OR password is incorrect!");
    }

    public boolean authorizationAdmin (String login, String password) {
        if (adminService.checkAdminByLogin(login, password)) {
            if (adminService.authorizationAdmin(login, password)) {
                return true;
            }
        }
        return false;
    }


    public void findAdminByLogin() {
        String adminLogin = readWithInvite("Input Administrator's Login: "), adminPassword = readWithInvite("Input Administrator's password: ");
        if ((adminService.checkAdminByLogin(adminLogin, adminPassword)))
            writeln("Founded Administrator:\n" + adminLogin);
        else
            writeln("Admin with Login(" + adminLogin + ") not found!");
    }

    public void findAdminById() {
        writeln("Input Administrator's Id: ");
        long adminId = readId();
        String adminPassword = readWithInvite("Input Administrator's password: ");
        if ((adminService.checkAdminById(adminId, adminPassword)))
            writeln("Founded Administrator with Id: " + adminId);
        else
            writeln("Admin with Login(" + adminId + ") not found!");
    }

    public void updateAdminNameById() {
        Writer.writeln("Input Administrator's Id:");
        Long adminId = readId();
        String adminPassword = readWithInvite("Input Administrator's password:");
        String adminNewName = readWithInvite("Input Administrator's new name:");
        if (adminService.updateAdminNameById(adminId, adminPassword, adminNewName))
            Writer.writeln("New name of Administrator with id " + adminId + " was set");
        else writeln("Id " + adminId + " or password is incorrect!");
    }
}