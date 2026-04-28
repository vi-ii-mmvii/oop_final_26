package system;

import enums.RequestStatus;
import users.Employee;
import enums.UrgencyLevel;

public class Request {
    private String title;
    private String description;
    private Employee author;
    private RequestStatus status;
    private UrgencyLevel urgency;

    public Request(String title, String description, Employee author, UrgencyLevel urgency) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.status = RequestStatus.NEW;
        this.urgency = urgency;
    }

    public void markViewed() {
        if (status == RequestStatus.NEW) {
            status = RequestStatus.VIEWED;
        }
    }

    public void accept() {
        status = RequestStatus.ACCEPTED;
    }

    public void reject() {
        status = RequestStatus.REJECTED;
    }

    public void done() {
        status = RequestStatus.DONE;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Employee getAuthor() {
        return author;
    }

    public RequestStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Request{" +
                "title='" + title + '\'' +
                ", author=" + author.getName() +
                ", status=" + status +
                '}';
    }
}