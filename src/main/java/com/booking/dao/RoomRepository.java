package com.booking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {

}
