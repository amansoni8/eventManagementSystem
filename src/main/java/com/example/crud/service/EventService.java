package com.example.crud.service;

import java.util.List;
import java.util.Optional;

import com.example.crud.entity.Event;
import com.example.crud.pojo.EventPojo;

public interface EventService {

	 Event getEventById(Integer eventId);
	    List<Event> getAllEvents();
	    void createEvent(EventPojo eventPojo);
		void updateEvent(Event updatedEvent, Integer eventId);
	    
}
