package com.booking.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="room")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="room_number")
	private int roomNumber;
	
	@Column(name="bed_type")
	private String roomType;
	
	@Column(name="availablity")
	private boolean roomStatus;
	
	@Column(name="rate")
	private int roomRate;
	
	public Room() {
		
	}

	public Room(int roomNumber, String roomType, boolean roomStatus, int roomRate) {
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.roomStatus = roomStatus;
		this.roomRate = roomRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public boolean getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(boolean roomStatus) {
		this.roomStatus = roomStatus;
	}

	public int getRoomRate() {
		return roomRate;
	}

	public void setRoomRate(int roomRate) {
		this.roomRate = roomRate;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", roomNumber=" + roomNumber + ", roomType=" + roomType + ", roomStatus=" + roomStatus
				+ ", roomRate=" + roomRate + "]";
	}
	
	
	
	
}
