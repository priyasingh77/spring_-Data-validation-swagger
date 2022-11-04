package com.usermgm.controller;

import java.util.List;

import javax.validation.Valid;

import com.usermgm.dto.userDTO;
import com.usermgm.exception.globalException;

import com.usermgm.model.user;
import com.usermgm.service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Class-level annotation
@RequestMapping("/user")
public class userController {
	
	// creating dependency injection for service layer
	@Autowired
	private userService service;
	
	
	
	@GetMapping("/hello")
	public String helloUser() {
		
		return "Hello welcome to swagger";
		}
	
	// Mapping Method ->1  to add user in the DB
	@PostMapping("/add")
	public ResponseEntity<user> addUser(@RequestBody @Valid userDTO u1){
		
		return new ResponseEntity<>(service.addUser(u1),HttpStatus.OK);
	}
	
	//Mapping Method ->2  to retriving all user form  DB
	@GetMapping("/retrive")
	public ResponseEntity<List<user>> getUser(){
		
		return new ResponseEntity<>(service.getUser(),HttpStatus.ACCEPTED);	
	}
	//Mapping Method ->3  to delete the user from the DB
	@DeleteMapping ("/delete/{id}")
	public ResponseEntity<user> deleteUser(@PathVariable int id)throws globalException{
		
		return new ResponseEntity<>(service.deleteUser(id),HttpStatus.ACCEPTED);
	}
	//Mapping Method ->4  to update the  user in the DB
	@PutMapping("/update")
	public ResponseEntity<user>updateUser(@RequestBody @Valid userDTO u1){
		return new ResponseEntity<>(service.addUser(u1),HttpStatus.OK);
	}
	//Mapping Method ->5  to retriving   user via id
	@GetMapping("/{id}")
	public ResponseEntity<user> getUSer(@PathVariable int id)throws globalException{
		return new ResponseEntity<>(service.getUser(id),HttpStatus.OK);
	}
	

}
