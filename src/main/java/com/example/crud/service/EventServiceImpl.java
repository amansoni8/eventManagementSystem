package com.example.crud.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.entity.Event;
import com.example.crud.pojo.EventPojo;
import com.example.crud.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {
	@Autowired
	 private final EventRepository eventRepository;

	    
	    public EventServiceImpl(EventRepository eventRepository) {
	        this.eventRepository = eventRepository;
	    }
	
	@Override
	public Event getEventById(Integer eventId) {
		// TODO Auto-generated method stub
		Event event = eventRepository.findById(eventId).get();
		return event;
	}

	@Override
	public List<Event> getAllEvents() {
		// TODO Auto-generated method stub
		List<Event> events = eventRepository.findAll();
		return events;
	}

	@Override
	public void createEvent(EventPojo eventPojo) {
		// TODO Auto-generated method stub
		
		Event event = new Event();
		
		try {
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		    Date parsedDate = dateFormat.parse(eventPojo.getStartTime());
		    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
		    event.setStartTime(timestamp);
		} catch(Exception e) { //this generic but you can control another types of exception
		    // look the origin of excption 
		}
//		event.setEventId(1);
		event.setEventName(eventPojo.getEventName());
		event.setCreateDate(new Date());
		event.setModifyDate(new Date());
		
//		eventPojo.getStartTime();
		
		eventRepository.save(event);
		  
	}

	@Override
	public void updateEvent(Event event, Integer eventId) {
		// TODO Auto-generated method stub
		
		Event e = eventRepository.findById(eventId).get();
		if(event.getEventName() != null) {
			e.setEventName(event.getEventName());
		}
		e.setModifyDate(new Date());
		 eventRepository.save(event);
	}

	

	  
		
}
