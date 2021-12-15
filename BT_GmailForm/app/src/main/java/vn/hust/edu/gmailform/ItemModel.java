package vn.hust.edu.gmailform;

public class ItemModel {
    String sender, content, time;

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public ItemModel(String sender, String content, String time) {
        this.sender = sender;
        this.content = content;
        this.time = time;
    }
}