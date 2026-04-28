package system;

import users.Employee;
import java.time.LocalDateTime;

public class Message {
    private Employee sender;
    private Employee receiver;
    private String title;
    private String content;
    private LocalDateTime publishedTime;
    private boolean read;

    public Message(Employee sender, Employee receiver, String title, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.title = title;
        this.content = content;
        this.publishedTime = LocalDateTime.now();
        this.read = false;
    }
    
    public void prochitano() {
    	this.read = true;
    }

    public Employee getSender() {
        return sender;
    }

    public Employee getReceiver() {
        return receiver;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
    
    public LocalDateTime getPublishedTime() {
    	return publishedTime;
    }
    
    public boolean isProchitano() {
    	return read;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender=" + sender.getName() +
                ", receiver=" + receiver.getName() +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publishedTime=" + publishedTime +
                ", prochitano = " + read + 
                '}';
    }
}