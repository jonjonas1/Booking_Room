package com.booking.service;

import java.util.List;

import com.booking.entity.Room;

public interface RoomService {

	public List<Room> findAll();
	
	public Room findById(int theId);

	public void save(Room theRoom);

	public void deleteById(int theId);
	
}
