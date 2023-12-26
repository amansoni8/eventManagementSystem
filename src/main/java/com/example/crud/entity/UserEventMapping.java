package com.example.crud.entity;

import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserEventMapping {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Integer id;

	    @ManyToOne
	    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	    private User user;

	    @ManyToOne
	    @JoinColumn(name = "event_id", referencedColumnName = "event_id")
	    private Event event;
	    
//	    @Column(name = "user_id")
//	    private Integer userId;
//	    
//	    @Column(name = "event_id")
//	    private Integer eventId;

	    @Column(name = "event_name", length = 30)
	    private String eventName;

	    @Column(name = "start_time")
	    private Timestamp startTime;

	    @Column(name = "end_time")
	    private Timestamp endTime;

	    @Column(name = "is_active", length = 30)
	    private String isActive;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Event getEvent() {
			return event;
		}

		public void setEvent(Event event) {
			this.event = event;
		}
		
		

		public String getEventName() {
			return eventName;
		}

//		public Integer getUserId() {
//			return userId;
//		}
//
//		public void setUserId(Integer userId) {
//			this.userId = userId;
//		}
//
//		public Integer getEventId() {
//			return eventId;
//		}

//		public void setEventId(Integer eventId) {
//			this.eventId = eventId;
//		}

		public void setEventName(String eventName) {
			this.eventName = eventName;
		}

		public Timestamp getStartTime() {
			return startTime;
		}

		public void setStartTime(Timestamp startTime) {
			this.startTime = startTime;
		}

		public Timestamp getEndTime() {
			return endTime;
		}

		public void setEndTime(Timestamp endTime) {
			this.endTime = endTime;
		}

		public String getIsActive() {
			return isActive;
		}

		public void setIsActive(String isActive) {
			this.isActive = isActive;
		}

	    
	    
}
