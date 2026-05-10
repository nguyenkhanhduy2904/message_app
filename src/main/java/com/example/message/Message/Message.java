package com.example.message.Message;

import com.example.message.Room.Room;
import com.example.message.User.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "message")
public class Message {


    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "content")
    private String content;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "prediction")
    private String prediction;
    @Column(name = "confidence")
    private Double confidence;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Message(String content, LocalDateTime createdAt, String prediction, Double confidence, User user, Room room) {
        this.content = content;
        this.createdAt = createdAt;
        this.prediction = prediction;
        this.confidence = confidence;
        this.user = user;
        this.room = room;
    }

    public Message() {
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

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
