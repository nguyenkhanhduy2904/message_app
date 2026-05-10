package com.example.message.Message;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByRoom_IdOrderByCreatedAtAsc(Integer roomId);
}
