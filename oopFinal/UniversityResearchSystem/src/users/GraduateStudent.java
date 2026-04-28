package users;

import java.util.ArrayList;
import java.util.List;

public class GraduateStudent extends Student {
    private String degreeType;
    private String supervisorName;
    private List<String> diplomaProjectPapers;

    public GraduateStudent(String id, String name, String email, String major, int yearOfStudy,
                           String degreeType, String supervisorName) {
        super(id, name, email, major, yearOfStudy);
        this.degreeType = degreeType;
        this.supervisorName = supervisorName;
        this.diplomaProjectPapers = new ArrayList<>();
    }

    @Override
    public String getRole() {
        return "GraduateStudent";
    }

    public void addDiplomaProjectPaper(String paperTitle) {
        diplomaProjectPapers.add(paperTitle);
    }

    public String getDegreeType() {
        return degreeType;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public List<String> getDiplomaProjectPapers() {
        return diplomaProjectPapers;
    }

    @Override
    public String toString() {
        return "GraduateStudent{" +
                "name='" + getName() + '\'' +
                ", degreeType='" + degreeType + '\'' +
                ", supervisorName='" + supervisorName + '\'' +
                ", papers=" + diplomaProjectPapers +
                '}';
    }
}