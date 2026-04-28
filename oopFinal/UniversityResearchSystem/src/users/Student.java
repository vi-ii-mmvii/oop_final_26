package users;

import academic.Course;
import academic.Mark;
import academic.Transcript;
import exceptions.CreditLimitExceededException;
import exceptions.TooManyFailsException;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private static final int MAX_CREDITS = 21;
    private static final int MAX_FAILS = 3;

    private String major;
    private int yearOfStudy;
    private List<Course> registeredCourses;
    private Transcript transcript;

    public Student(String id, String name, String email, String major, int yearOfStudy) {
        super(id, name, email);
        this.major = major;
        this.yearOfStudy = yearOfStudy;
        this.registeredCourses = new ArrayList<>();
        this.transcript = new Transcript();
    }

    @Override
    public String getRole() {
        return "Student";
    }

    public void registerCourse(Course course) throws CreditLimitExceededException, TooManyFailsException {
        if (transcript.getFailedCoursesCount() >= MAX_FAILS) {
            throw new TooManyFailsException("Registration denied: student has 3 or more failed courses.");
        }

        if (getCurrentCredits() + course.getCredits() > MAX_CREDITS) {
            throw new CreditLimitExceededException("Registration denied: credit limit exceeded (max 21).");
        }

        if (!registeredCourses.contains(course)) {
            registeredCourses.add(course);
            course.enrollStudent(this);
        }
    }

    public void addMark(Course course, Mark mark) {
        transcript.addRecord(course, mark);
    }

    public int getCurrentCredits() {
        int total = 0;
        for (Course course : registeredCourses) {
            total += course.getCredits();
        }
        return total;
    }

    public int getFailedCoursesCount() {
        return transcript.getFailedCoursesCount();
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public String getMajor() {
        return major;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", major='" + major + '\'' +
                ", yearOfStudy=" + yearOfStudy +
                ", currentCredits=" + getCurrentCredits() +
                ", failedCourses=" + getFailedCoursesCount() +
                ", gpa=" + String.format("%.2f", transcript.calculateGPA()) +
                '}';
    }
}