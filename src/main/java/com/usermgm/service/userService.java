package com.usermgm.service;

import java.util.List;

import com.usermgm.dto.userDTO;
import com.usermgm.exception.globalException;
import com.usermgm.model.user;
import com.usermgm.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
	
	//creating dependency injection for repository
	@Autowired
	private userRepository userepo;
	
	// Method ->1  to adding  user which satisfies user validation
	public user addUser(userDTO u1) {
		
		user u2 =user.build(u1.getUserId(), u1.getUserName(), u1.getUserPhone(), u1.getUserEmail(), u1.getUserPassword());
		return userepo.save(u2);
	}
	
	// Method ->2 to retriving all the users
	public List<user>getUser(){
		return userepo.findAll();
	}
	
	//Method ->3  to delete the from DB
	public user deleteUser(int id )throws globalException{
		
		user _u2=userepo.findByUserId(id);
		if(_u2!=null) {
			
			userepo.deleteById(id);
			return _u2;
		}
		else {
			throw new globalException("user not found!...");
		}
	}
	//Method ->4 to update the user  details in the DB
	public user updateUser(userDTO u1) {
		
		user u2= user.build(u1.getUserId(), u1.getUserName(), u1.getUserPhone(), u1.getUserEmail(),u1.getUserPassword());
		return userepo.save(u2);
		
	}
	// Method ->5  to retriving the details of specific user
	public user getUser(int userid) throws globalException{
		
		user _u1=userepo.findByUserId(userid);
		if(_u1!=null) {
			return _u1;
		}
		else {
			throw new globalException("user not found with userid "+userid);
		}
	}

}
