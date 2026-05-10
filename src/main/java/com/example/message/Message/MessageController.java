package com.example.message.Message;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/message")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public MessageResponse sendMessage(@RequestBody MessageRequest message){
        return messageService.sendMessage(message);
    }

    @GetMapping("/room/{roomId}")
    public List<MessageResponse> getAllMessageFromRoom(@PathVariable Integer roomId){
        return messageService.getAllMessageFromRoom(roomId);
    }

}
