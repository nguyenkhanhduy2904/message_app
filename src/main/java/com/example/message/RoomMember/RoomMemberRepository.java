package com.example.message.RoomMember;

import com.example.message.Room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RoomMemberRepository extends JpaRepository<RoomMember, Integer> {

    // Find all members in a room
    List<RoomMember> findByRoom_Id(Integer roomId);

    // Find shared room between two users
    @Query("""
        SELECT rm1.room FROM RoomMember rm1
        JOIN RoomMember rm2 ON rm1.room = rm2.room
        WHERE rm1.user.userId = :userId1 AND rm2.user.userId = :userId2
    """)
    Optional<Room> findSharedRoom(@Param("userId1") Integer userId1,
                                  @Param("userId2") Integer userId2);
}
