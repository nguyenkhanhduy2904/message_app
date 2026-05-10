package com.example.message.RoomMember;

import com.example.message.Room.Room;
import com.example.message.Room.RoomRepository;
import com.example.message.User.User;
import com.example.message.User.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomMemberService {

    private final RoomMemberRepository roomMemberRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    public RoomMemberService(RoomMemberRepository roomMemberRepository, RoomRepository roomRepository, UserRepository userRepository) {
        this.roomMemberRepository = roomMemberRepository;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }

    public Room getOrCreateRoom(Integer userId1, Integer userId2) {
        // If a shared room already exists, return it
        return roomMemberRepository.findSharedRoom(userId1, userId2)
                .orElseGet(() -> {
                    // Otherwise create a new room and add both users
                    User user1 = userRepository.findById(userId1).orElseThrow();
                    User user2 = userRepository.findById(userId2).orElseThrow();

                    Room newRoom = roomRepository.save(new Room());
                    roomMemberRepository.save(new RoomMember(newRoom, user1));
                    roomMemberRepository.save(new RoomMember(newRoom, user2));

                    return newRoom;
                });
    }
}
