package com.example.crud.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.crud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByfirstName(String firstName);

}
