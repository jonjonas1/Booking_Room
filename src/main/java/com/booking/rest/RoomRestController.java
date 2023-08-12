package com.booking.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.entity.Room;
import com.booking.service.RoomService;

@RestController
@RequestMapping("/api")
public class RoomRestController {
	
	private RoomService roomService;
	
	@Autowired
	public RoomRestController(RoomService theRoomService) {
		roomService=theRoomService;
	}
	
	@GetMapping("/rooms")
	public List<Room> findAll() {
		return roomService.findAll();
	}
	
	@GetMapping("/rooms/{roomId}")
	public Room getRoom(@PathVariable int roomId) {
		Room theRoom = roomService.findById(roomId);

		if (theRoom == null) {
			throw new RuntimeException("Room id not found - " + roomId);
		}
		return theRoom;
	}
	
	@PostMapping("/rooms")
	public Room addRoom(@RequestBody Room theRoom) {

		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		theRoom.setId(0);
		roomService.save(theRoom);

		return theRoom;
	}
	
	@PutMapping("/rooms")
	public Room updateRoom(@RequestBody Room theRoom) {

		roomService.save(theRoom);

		return theRoom;
	}
	
	@DeleteMapping("/rooms/{roomId}")
	public String deleteRoom(@PathVariable int roomId) {

		Room tempRoom = roomService.findById(roomId);
		// throw exception if null
		if (tempRoom == null) {
			throw new RuntimeException("Room id not found - " + roomId);
		}
		
		roomService.deleteById(roomId);

		return "Deleted room id - " + roomId;
	}
}
