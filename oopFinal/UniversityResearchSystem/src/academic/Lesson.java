package academic;

import enums.LessonType;

public class Lesson {
    private LessonType type;
    private String room;
    private String day;
    private String time;

    public Lesson(LessonType type, String room, String day, String time) {
        this.type = type;
        this.room = room;
        this.day = day;
        this.time = time;
    }

    public LessonType getType() {
        return type;
    }

    public String getRoom() {
        return room;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "type=" + type +
                ", room='" + room + '\'' +
                ", day='" + day + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}