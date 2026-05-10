package com.example.message.RoomMember;

import com.example.message.Room.Room;
import com.example.message.User.User;
import jakarta.persistence.*;

@Entity
@Table(name = "room_member")
public class RoomMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public RoomMember() {
    }

    public RoomMember(Integer id, Room room, User user) {
        this.id = id;
        this.room = room;
        this.user = user;
    }

    public RoomMember(Room room, User user) {
        this.room = room;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
