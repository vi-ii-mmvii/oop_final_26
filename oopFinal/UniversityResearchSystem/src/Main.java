import academic.Complaint;
import academic.Course;
import academic.Lesson;
import academic.Mark;
import enums.CourseType;
import enums.LessonType;
import enums.TeacherPosition;
import enums.UrgencyLevel;
import exceptions.CreditLimitExceededException;
import exceptions.TooManyFailsException;
import users.Student;
import users.Teacher;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher(
                "T001",
                "Dr. Brown",
                "brown@kbtu.kz",
                500000,
                10,
                TeacherPosition.PROFESSOR
        );

        Student student = new Student(
                "S001",
                "Zhanna",
                "zhanna@kbtu.kz",
                "IT",
                2
        );

        Course oop = new Course("CS101", "Object-Oriented Programming", 6, CourseType.MAJOR);
        oop.setLectureTeacher(teacher);
        oop.setPracticeTeacher(teacher);

        oop.addLesson(new Lesson(LessonType.LECTURE, "302", "Monday", "10:00"));
        oop.addLesson(new Lesson(LessonType.PRACTICE, "105", "Wednesday", "12:00"));

        teacher.addCourse(oop);

        try {
            student.registerCourse(oop);
        } catch (CreditLimitExceededException | TooManyFailsException e) {
            System.out.println(e.getMessage());
        }

        teacher.putMark(student, oop, new Mark(25, 20, 30));

        Complaint complaint = teacher.sendComplaint(
                student,
                "Student missed multiple practice lessons.",
                UrgencyLevel.MEDIUM
        );

        System.out.println("=== TEACHER ===");
        System.out.println(teacher);

        System.out.println("\n=== STUDENT ===");
        System.out.println(student);

        System.out.println("\n=== COURSE ===");
        System.out.println(oop);

        System.out.println("\n=== LESSONS ===");
        for (Lesson lesson : oop.getLessons()) {
            System.out.println(lesson);
        }

        System.out.println("\n=== TRANSCRIPT ===");
        System.out.println(student.getTranscript());

        System.out.println("=== COMPLAINT ===");
        System.out.println(complaint);
    }
}