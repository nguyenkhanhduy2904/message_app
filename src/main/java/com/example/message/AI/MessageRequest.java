package com.example.message.AI;

public class MessageRequest {
    private String text;

    public MessageRequest(String text) {
        this.text = text;
    }

    public MessageRequest() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
