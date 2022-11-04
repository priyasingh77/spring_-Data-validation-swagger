package com.usermgm.repository;

import com.usermgm.model.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface userRepository extends JpaRepository<user,Integer> {
	
	
	@Query(value ="select*from user where user_id=?1",nativeQuery=true)
	user findByUserId(int id);
	

}
