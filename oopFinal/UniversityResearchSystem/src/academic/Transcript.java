package academic;

import java.util.HashMap;
import java.util.Map;

public class Transcript {
    private Map<Course, Mark> records;

    public Transcript() {
        this.records = new HashMap<>();
    }

    public void addRecord(Course course, Mark mark) {
        records.put(course, mark);
    }

    public Mark getMark(Course course) {
        return records.get(course);
    }

    public int getFailedCoursesCount() {
        int count = 0;
        for (Mark mark : records.values()) {
            if (!mark.isPassed()) {
                count++;
            }
        }
        return count;
    }

    public double calculateGPA() {
        if (records.isEmpty()) return 0.0;

        double totalPoints = 0;
        int totalCredits = 0;

        for (Map.Entry<Course, Mark> entry : records.entrySet()) {
            int credits = entry.getKey().getCredits();
            double totalMark = entry.getValue().getTotal();

            double gpaPoints;
            if (totalMark >= 95) gpaPoints = 4.0;
            else if (totalMark >= 90) gpaPoints = 3.67;
            else if (totalMark >= 85) gpaPoints = 3.33;
            else if (totalMark >= 80) gpaPoints = 3.0;
            else if (totalMark >= 75) gpaPoints = 2.67;
            else if (totalMark >= 70) gpaPoints = 2.33;
            else if (totalMark >= 65) gpaPoints = 2.0;
            else if (totalMark >= 60) gpaPoints = 1.67;
            else if (totalMark >= 55) gpaPoints = 1.33;
            else if (totalMark >= 50) gpaPoints = 1.0;
            else gpaPoints = 0.0;

            totalPoints += gpaPoints * credits;
            totalCredits += credits;
        }

        return totalCredits == 0 ? 0.0 : totalPoints / totalCredits;
    }

    public Map<Course, Mark> getRecords() {
        return records;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Transcript:\n");
        for (Map.Entry<Course, Mark> entry : records.entrySet()) {
            sb.append(entry.getKey().getCode())
              .append(" - ")
              .append(entry.getKey().getTitle())
              .append(" : ")
              .append(entry.getValue())
              .append("\n");
        }
        sb.append("GPA: ").append(String.format("%.2f", calculateGPA())).append("\n");
        return sb.toString();
    }
}