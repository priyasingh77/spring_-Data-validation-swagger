package com.usermgm.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName="build")
@NoArgsConstructor
@Data
@Entity
public class user {
	// The @Id annotation specifies the primary key of the entity 
	@Id
	private int userId;
	private String userName;
	private String userphone;
	private String userEmail;
	private String userpassword;

}
