package system;

import users.User;
import java.time.LocalDateTime;

public class Comment {
    private User author;
    private String text;
    private LocalDateTime publishedTime;

    public Comment(User author, String text) {
        this.author = author;
        this.text = text;
        this.publishedTime = LocalDateTime.now();
    }

    public User getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return author.getName() + ": " + text + " Published at: " + publishedTime;
    }
}