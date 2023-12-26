package com.example.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "user_id")
 private Integer userId;

 @Column(name = "first_name", length = 30)
 private String firstName;

 @Column(name = "last_name", length = 30)
 private String lastName;

 @Column(name = "email", length = 30)
 private String email;

 @Column(name = "contact")
 private Long contact;

 @Column(name = "create_date")
 private int createDate;

 @Column(name = "modified_date")
 private int modifiedDate;

 @Column(name = "password", length = 30)
 private String password;

 @Column(name = "is_active", length = 30)
 private String isActive;

 
 
public Integer getUserId() {
	return userId;
}

public void setUserId(Integer userId) {
	this.userId = userId;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Long getContact() {
	return contact;
}

public void setContact(Long contact) {
	this.contact = contact;
}

public int getCreateDate() {
	return createDate;
}

public void setCreateDate(int createDate) {
	this.createDate = createDate;
}

public int getModifiedDate() {
	return modifiedDate;
}

public void setModifiedDate(int modifiedDate) {
	this.modifiedDate = modifiedDate;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getIsActive() {
	return isActive;
}

public void setIsActive(String isActive) {
	this.isActive = isActive;
}

 

}
