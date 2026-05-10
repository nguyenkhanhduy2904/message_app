package com.example.message.Room;

import jakarta.persistence.*;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    public Room(Integer id) {
        this.id = id;
    }

    public Room() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
