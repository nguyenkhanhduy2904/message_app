package com.example.message.RoomMember;

import com.example.message.Room.Room;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/room-member")
public class RoomMemberController {
    private final RoomMemberService roomMemberService;

    public RoomMemberController(RoomMemberService roomMemberService) {
        this.roomMemberService = roomMemberService;
    }

    @GetMapping("/{userId1}/{userId2}")
    public Room getOrCreateRoom(@PathVariable Integer userId1,
                                @PathVariable Integer userId2) {
        return roomMemberService.getOrCreateRoom(userId1, userId2);
    }
}
