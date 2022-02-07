package com.java.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoomService {
	
	@Autowired
	private RoomRespository repo;
	
	@Autowired
	private RoomDAO dao;
	
	public List<Room> showRoom() {
		return repo.findAll();
	}
	
	public Room search(String roomId) {
		return repo.findById(roomId).get();
	}
	
	public String RoomAvailable(String status) {
		return dao.RoomAvailable(status);
	}
	
	public String RoomBooked(String status) {
		return dao.RoomBooked(status);
	}


	
}
