package com.example.demo.chat.RoomUser;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.chat.Room.ChatRoom;
import com.example.demo.users.Users;

import jakarta.transaction.Transactional;

@Repository
public interface RoomUserDao extends JpaRepository<RoomUser, Long> {
	List<RoomUser> findByRoom_Chatroomid(String chatroomid);

	List<RoomUser> findByRoomuser_Id(String id);

	Optional<RoomUser> findByRoomAndRoomuser(ChatRoom room, Users roomuser);
	
	@Modifying
	@Query("DELETE FROM RoomUser WHERE room.chatroomid = :chatroomid")
	void deleteByRoom_chatroomid(String chatroomid);
}
