package com.example.message.Message;

import com.example.message.AI.AIService;
import com.example.message.AI.PredictionResponse;
import com.example.message.Room.Room;
import com.example.message.Room.RoomRepository;
import com.example.message.User.User;
import com.example.message.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;
    private final AIService aiService;

    @Autowired
    public MessageService(MessageRepository messageRepository, RoomRepository roomRepository, UserRepository userRepository, AIService aiService) {
        this.messageRepository = messageRepository;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
        this.aiService = aiService;
    }

    private MessageResponse toResponse(Message message) {
        MessageResponse res = new MessageResponse();

        res.setId(message.getId());
        res.setContent(message.getContent());
        res.setCreatedAt(message.getCreatedAt());
        res.setPrediction(message.getPrediction());
        res.setConfidence(message.getConfidence());

        res.setUserId(message.getUser().getUserId());
        res.setUserName(message.getUser().getUserName());

        res.setRoomId(message.getRoom().getId());

        return res;
    }

    public MessageResponse sendMessage(MessageRequest message) {
        User existedUser = userRepository.findById(message.getUserId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        Room existedRoom = roomRepository.findById(message.getRoomId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found"));

        PredictionResponse result = aiService.predict(message.getContent());

        Message newMessage = new Message(message.getContent(), LocalDateTime.now(), result.getLabel(), result.getConfidence(), existedUser, existedRoom);

        Message savedMessage = messageRepository.save(newMessage);



        return toResponse(savedMessage);

    }

    public List<MessageResponse> getAllMessageFromRoom(Integer roomId) {

        Room existedRoom = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found"));

        return messageRepository.findByRoom_IdOrderByCreatedAtAsc(roomId)
                .stream()
                .map(this::toResponse)   // 🔥 convert each item
                .toList();
    }
}
