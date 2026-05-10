package com.example.message.Message;


public class MessageRequest {
    private String content;

    private Integer userId;

    private Integer roomId;

    public MessageRequest(String content, Integer userId, Integer roomId) {
        this.content = content;

        this.userId = userId;
        this.roomId = roomId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }
}
