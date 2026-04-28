package users;

import academic.Course;
import enums.ManagerType;
import exceptions.CreditLimitExceededException;
import exceptions.TooManyFailsException;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
    private ManagerType managerType;
    private List<Course> availableCourses;

    public Manager(String id, String name, String email, double salary, int yearsOfService, ManagerType managerType) {
        super(id, name, email, salary, yearsOfService);
        this.managerType = managerType;
        this.availableCourses = new ArrayList<>();
    }

    @Override
    public String getRole() {
        return "Manager";
    }

    public void addCourseForRegistration(Course course) {
        if (!availableCourses.contains(course)) {
            availableCourses.add(course);
        }
    }

    public void approveRegistration(Student student, Course course)
            throws CreditLimitExceededException, TooManyFailsException {
        if (availableCourses.contains(course)) {
            student.registerCourse(course);
        }
    }

    public void assignCourseToTeacher(Course course, Teacher teacher, boolean isLectureTeacher) {
        if (isLectureTeacher) {
            course.setLectureTeacher(teacher);
        } else {
            course.setPracticeTeacher(teacher);
        }
        teacher.addCourse(course);
    }

    public ManagerType getManagerType() {
        return managerType;
    }

    public List<Course> getAvailableCourses() {
        return availableCourses;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", managerType=" + managerType +
                '}';
    }
}