package domain;

public class Message {
    public int priority;

    public String content;

    public Message(int priority, String content) {
        this.priority = priority;
        this.content = content;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "priority=" + priority +
                ", content='" + content + '\'' +
                '}';
    }
}
