import academic.Complaint;
import academic.Course;
import academic.Lesson;
import academic.Mark;
import enums.*;
import exceptions.CreditLimitExceededException;
import exceptions.TooManyFailsException;
import system.Message;
import system.News;
import system.Request;
import users.*;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher(
                "T001", "Dr. Brown", "brown@kbtu.kz",
                500000, 10, TeacherPosition.PROFESSOR
        );

        Manager manager = new Manager(
                "M001", "Aigerim Sarsen", "aigerim@kbtu.kz",
                600000, 8, ManagerType.OR
        );

        Admin admin = new Admin(
                "A001", "Admin User", "admin@kbtu.kz",
                550000, 6
        );

        TechSupportSpecialist tech = new TechSupportSpecialist(
                "TS001", "Nursultan", "tech@kbtu.kz",
                400000, 4
        );

        Student student = new Student(
                "S001", "wewewe", "wewewe@kbtu.kz",
                "IT", 2
        );

        GraduateStudent gradStudent = new GraduateStudent(
                "G001", "Dias", "dias@kbtu.kz",
                "Data Science", 1, "Master", "Prof. Nurgaliyev"
        );

        admin.addUser(teacher);
        admin.addUser(manager);
        admin.addUser(student);
        admin.addUser(gradStudent);
        admin.addUser(tech);

        Course oop = new Course("CS101", "Object-Oriented Programming", 6, CourseType.MAJOR);
        oop.addLesson(new Lesson(LessonType.LECTURE, "302", "Monday", "10:00"));
        oop.addLesson(new Lesson(LessonType.PRACTICE, "105", "Wednesday", "12:00"));

        manager.addCourseForRegistration(oop);
        manager.assignCourseToTeacher(oop, teacher, true);
        manager.assignCourseToTeacher(oop, teacher, false);

        try {
            manager.approveRegistration(student, oop);
            manager.approveRegistration(gradStudent, oop);
        } catch (CreditLimitExceededException | TooManyFailsException e) {
            System.out.println(e.getMessage());
        }

        teacher.putMark(student, oop, new Mark(25, 20, 30));
        teacher.putMark(gradStudent, oop, new Mark(28, 27, 35));

        Complaint complaint = teacher.sendComplaint(
                student,
                "Student missed multiple practice lessons.",
                UrgencyLevel.MEDIUM
        );

        Message message = teacher.sendMessage(
                manager,
                "Exam Room Request",
                "Please book room 401 for the final exam."
        );

        News news = new News(
                "Research Week",
                "Research week starts next Monday.",
                NewsTopic.RESEARCH
        );
        news.addComment(student, "Great news!");
        news.addComment(teacher, "Please join the opening session.");

        Request request = new Request(
                "Projector issue",
                "Projector in room 302 is not working.",
                teacher
        );

        tech.seeRequest(request);
        tech.acceptRequest(request);
        tech.completeRequest(request);

        System.out.println("=== ADMIN ===");
        System.out.println(admin);
        System.out.println("Logs: " + admin.getLogs());

        System.out.println("\n=== MESSAGE ===");
        System.out.println(message);

        System.out.println("\n=== NEWS ===");
        System.out.println(news);
        for (var comment : news.getComments()) {
            System.out.println(comment);
        }

        System.out.println("\n=== REQUEST ===");
        System.out.println(request);

        System.out.println("\n=== STUDENT TRANSCRIPT ===");
        System.out.println(student.getTranscript());

        System.out.println("=== COMPLAINT ===");
        System.out.println(complaint);
    }
}