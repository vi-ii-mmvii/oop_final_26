package users;

public abstract class Employee extends User {
    protected double salary;
    protected int yearsOfService;

    public Employee(String id, String name, String email, double salary, int yearsOfService) {
        super(id, name, email);
        this.salary = salary;
        this.yearsOfService = yearsOfService;
    }

    public double getSalary() {
        return salary;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", yearsOfService=" + yearsOfService +
                ", role='" + getRole() + '\'' +
                '}';
    }
}