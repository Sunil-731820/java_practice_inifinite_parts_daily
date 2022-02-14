package com.java.hib;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.mapping.Map;

public class RoomDAO {
	SessionFactory sf;
	Session session;
	
	public List<Room> showRoom(){
		SessionFactory sf = SessionHelper.getFactory();
		Session session = sf.openSession();
		Query q = session.createQuery("from Room");
		List<Room> roomList = q.list();
		return roomList;
	}
	
	public Room searchRoom(String roomId) {
		SessionFactory sf = SessionHelper.getFactory();
		Session session = sf.openSession();
		Query q = session.createQuery("from Room where roomId="+roomId);
		List<Room> roomList = q.list();
		Room  room = null;
		if(roomList.size()==1) {
			room = roomList.get(0);
		}
		return room;
	}
	
	public String addRoom(Room room) {
		SessionFactory sf = SessionHelper.getFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(room);
		t.commit();
		return "Room  added SuccessFully";
	}
	
	public String BookRoom(Room room) {
		SessionFactory sf = SessionHelper.getFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.update(room);
		t.commit();
		return "Room Booked ...";
	}
	
	public String showAvailableRoom(String status) {
		SessionFactory sf = SessionHelper.getFactory();
		Session s = sf.openSession();
		Transaction tx = null;
		Transaction t = s.beginTransaction();
		String cmd = "select roomId, type,costPerDay where status=Available";
		SQLQuery query = session.createSQLQuery(cmd);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List data = query.list();

//        for(Object object : data) {
//           Map row = (Map)object;
//          
//        }
        tx.commit();
		return "Room available here";
	}

	
	
	
}
