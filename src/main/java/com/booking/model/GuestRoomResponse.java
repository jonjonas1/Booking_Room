package com.booking.model;

import java.util.List;

import com.booking.entity.Room;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuestRoomResponse {
	
	// One combined response Entity
	 
	private Room room;
	
	private List<Guest> guests;
	
	public GuestRoomResponse() {
		
	}
	
	public GuestRoomResponse(Room room, List<Guest> guests) {
		this.room = room;
		this.guests = guests;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public List<Guest> getGuests() {
		return guests;
	}
	public void setGuests(List<Guest> listOfGuests) {
		this.guests = listOfGuests;
	}
	
	
}
