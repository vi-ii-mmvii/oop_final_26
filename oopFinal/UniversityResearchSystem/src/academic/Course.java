package academic;

import enums.CourseType;
import users.Student;
import users.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {
    private String code;
    private String title;
    private int credits;
    private CourseType type;

    private Teacher lectureTeacher;
    private Teacher practiceTeacher;

    private List<Lesson> lessons;
    private List<Student> enrolledStudents;

    public Course(String code, String title, int credits, CourseType type) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.type = type;
        this.lessons = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
    }

    public void setLectureTeacher(Teacher lectureTeacher) {
        this.lectureTeacher = lectureTeacher;
    }

    public void setPracticeTeacher(Teacher practiceTeacher) {
        this.practiceTeacher = practiceTeacher;
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    public CourseType getType() {
        return type;
    }

    public Teacher getLectureTeacher() {
        return lectureTeacher;
    }

    public Teacher getPracticeTeacher() {
        return practiceTeacher;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return Objects.equals(code, course.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "Course{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", credits=" + credits +
                ", type=" + type +
                ", lectureTeacher=" + (lectureTeacher != null ? lectureTeacher.getName() : "none") +
                ", practiceTeacher=" + (practiceTeacher != null ? practiceTeacher.getName() : "none") +
                '}';
    }
}