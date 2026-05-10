package com.example.message.Message;

import java.time.LocalDateTime;

public class MessageResponse {
    private Integer id;
    private String content;
    private LocalDateTime createdAt;
    private String prediction;
    private double confidence;

    private Integer userId;
    private String userName;

    private Integer roomId;

    public MessageResponse(Integer id, String content, LocalDateTime createdAt, String prediction, double confidence, Integer userId, String userName, Integer roomId) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.prediction = prediction;
        this.confidence = confidence;
        this.userId = userId;
        this.userName = userName;
        this.roomId = roomId;
    }

    public MessageResponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }
}
