package system;

import users.Employee;

public class Message {
    private Employee sender;
    private Employee receiver;
    private String title;
    private String content;

    public Message(Employee sender, Employee receiver, String title, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.title = title;
        this.content = content;
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

    @Override
    public String toString() {
        return "Message{" +
                "sender=" + sender.getName() +
                ", receiver=" + receiver.getName() +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}