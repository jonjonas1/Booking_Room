package com.booking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}
