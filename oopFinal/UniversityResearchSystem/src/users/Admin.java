package users;

import java.util.ArrayList;
import java.util.List;

public class Admin extends Employee {
    private List<User> users;
    private List<String> logs;

    public Admin(String id, String name, String email, double salary, int yearsOfService) {
        super(id, name, email, salary, yearsOfService);
        this.users = new ArrayList<>();
        this.logs = new ArrayList<>();
    }

    @Override
    public String getRole() {
        return "Admin";
    }

    public void addUser(User user) {
        users.add(user);
        logs.add("Added user: " + user.getName());
    }

    public void removeUser(User user) {
        users.remove(user);
        logs.add("Removed user: " + user.getName());
    }

    public void updateUser(User user) {
        logs.add("Updated user: " + user.getName());
    }

    public List<User> getUsers() {
        return users;
    }

    public List<String> getLogs() {
        return logs;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", managedUsers=" + users.size() +
                '}';
    }
}