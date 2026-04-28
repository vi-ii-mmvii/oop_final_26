package system;

import enums.NewsTopic;
import users.User;

import java.util.ArrayList;
import java.util.List;

public class News {
    private String title;
    private String content;
    private NewsTopic topic;
    private boolean pinned;
    private List<Comment> comments;

    public News(String title, String content, NewsTopic topic) {
        this.title = title;
        this.content = content;
        this.topic = topic;
        this.pinned = topic == NewsTopic.RESEARCH;
        this.comments = new ArrayList<>();
    }

    public void addComment(User user, String text) {
        comments.add(new Comment(user, text));
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public NewsTopic getTopic() {
        return topic;
    }

    public boolean isPinned() {
        return pinned;
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", topic=" + topic +
                ", pinned=" + pinned +
                ", commentsCount=" + comments.size() +
                '}';
    }
}