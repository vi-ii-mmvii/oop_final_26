package users;

import academic.Complaint;
import academic.Course;
import academic.Mark;
import enums.TeacherPosition;
import enums.UrgencyLevel;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Employee {
    private TeacherPosition position;
    private List<Course> courses;

    public Teacher(String id, String name, String email, double salary, int yearsOfService, TeacherPosition position) {
        super(id, name, email, salary, yearsOfService);
        this.position = position;
        this.courses = new ArrayList<>();
    }

    @Override
    public String getRole() {
        return "Teacher";
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void putMark(Student student, Course course, Mark mark) {
        student.addMark(course, mark);
    }

    public Complaint sendComplaint(Student student, String text, UrgencyLevel urgencyLevel) {
        return new Complaint(this, student, text, urgencyLevel);
    }

    public TeacherPosition getPosition() {
        return position;
    }

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", yearsOfService=" + yearsOfService +
                ", position=" + position +
                '}';
    }
}