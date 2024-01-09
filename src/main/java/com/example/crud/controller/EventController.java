package com.example.crud.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.crud.entity.Event;
import com.example.crud.pojo.EventPojo;
import com.example.crud.service.EventService;

@Controller
@RequestMapping("/events")
public class EventController {

	private EventService EventService;
	
	@Autowired
	public EventController(EventService EventService){
		this.EventService = EventService;
	}

	@GetMapping("/{eventId}")
	public ResponseEntity<Event> getEventById(@PathVariable Integer eventId){
		return new ResponseEntity<Event>(EventService.getEventById(eventId), HttpStatus.OK);
	}
	@GetMapping   
	public ResponseEntity<List<Event>> getAllEvents(){
		List<Event> e= EventService.getAllEvents();
		return new ResponseEntity<List<Event>>(e, HttpStatus.OK);
		
	}
	@PostMapping
	public ResponseEntity<Event> createEvent(@RequestBody EventPojo eventPojo) {
        EventService.createEvent(eventPojo);	
		return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	@PutMapping("/{eventId}")
    public ResponseEntity<Event> updateEvent(@PathVariable Integer eventId, @RequestBody Event updatedEvent) {
		updatedEvent.setEventId(eventId);
        EventService.updateEvent(updatedEvent,eventId);   
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }
}
