package com.booking.model;

import com.booking.entity.Room;

public class GuestRoomResponse {
	
	// One combined response Entity
	 
	private Room room;
	
	private Guest guests;
	
	public GuestRoomResponse() {
		
	}

	public GuestRoomResponse(Room room, Guest guests) {
		super();
		this.room = room;
		this.guests = guests;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Guest getGuests() {
		return guests;
	}

	public void setGuests(Guest guests) {
		this.guests = guests;
	}
}
