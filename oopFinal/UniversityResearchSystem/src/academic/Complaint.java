package academic;

import enums.UrgencyLevel;
import users.Student;
import users.Teacher;

public class Complaint {
    private Teacher teacher;
    private Student student;
    private String text;
    private UrgencyLevel urgencyLevel;

    public Complaint(Teacher teacher, Student student, String text, UrgencyLevel urgencyLevel) {
        this.teacher = teacher;
        this.student = student;
        this.text = text;
        this.urgencyLevel = urgencyLevel;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Student getStudent() {
        return student;
    }

    public String getText() {
        return text;
    }

    public UrgencyLevel getUrgencyLevel() {
        return urgencyLevel;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "teacher=" + teacher.getName() +
                ", student=" + student.getName() +
                ", text='" + text + '\'' +
                ", urgencyLevel=" + urgencyLevel +
                '}';
    }
}