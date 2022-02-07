package com.java.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room {
	
	
	private String roomid;
	private String type;
	private String status;
	private int costperday;
	
	@Id
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCostperday() {
		return costperday;
	}
	public void setCostperday(int costperday) {
		this.costperday = costperday;
	}
	
	
	
	
	
	

}
