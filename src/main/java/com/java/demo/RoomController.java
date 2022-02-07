package com.java.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
	
	@Autowired
	private RoomService service;
	
	@RequestMapping(value="/showRoom")
	public List<Room> list() {
		return service.showRoom();
	}
	
	@RequestMapping("/room/{roomId}")
	public ResponseEntity<Room> get(@PathVariable String roomId) {
		try {
		Room room = service.search(roomId);
		return new ResponseEntity<Room>(room,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Room>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping("/roomAvailable/{status}")
	public String RoomAvailable(@PathVariable String status) {
		return service.RoomAvailable(status);
	}
	
	
	@RequestMapping("/roomBooked/{status}")
	public String RoomBooked(@PathVariable String status) {
		return service.RoomBooked(status);
	}

}
