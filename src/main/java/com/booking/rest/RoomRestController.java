package com.booking.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import com.booking.entity.Room;
import com.booking.model.Guest;
import com.booking.model.GuestRoomResponse;
import com.booking.service.RoomService;

@RestController
@RequestMapping("/api")
public class RoomRestController {

	@Autowired
	private RoomService roomService;

	@Autowired
	private RestTemplate restTemplate;

//	@Autowired
//	public RoomRestController(RoomService theRoomService) {
//		roomService=theRoomService;
//	}

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

	// same as above getRoom=getRoomById
	@GetMapping("/rooms/byid/{roomId}")
	public ResponseEntity<Room> getRoomById(@PathVariable Integer roomId) {
		Room theroom = roomService.findById(roomId);
		return new ResponseEntity<>(theroom, HttpStatus.OK);
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

	@GetMapping("/roomtype/{id}")
	public String getRoomType(@PathVariable int id) {
		String theRoom = roomService.findById(id).getRoomType();

		return theRoom;
	}

	@GetMapping("/rooms/id/{roomId}")
	public GuestRoomResponse getTheGuest(@PathVariable Integer roomId) {
		GuestRoomResponse guestRoomResponse = new GuestRoomResponse();


		// 1sr get room detail
		Room theroom = roomService.findById(roomId);

		guestRoomResponse.setRoom(theroom);

		// then get all Guest registered to room
		// to connect from one service to another service we need restTemplate
		Guest listOfGuests = restTemplate.getForObject("http://localhost:8081/api/guests/" + roomId, Guest.class);
		guestRoomResponse.setGuests(listOfGuests);


		return new ResponseEntity<GuestRoomResponse>(guestRoomResponse, HttpStatus.OK).getBody();
	}

	// get guest info in string
	@RequestMapping("/rooms/guest/{roomId}")
	public String ddd(@PathVariable Integer roomId) {
		String micro = "http://localhost:8081/api/guests/" + roomId;
		String response = restTemplate.getForObject(micro, String.class);
		return response;
	}

}
