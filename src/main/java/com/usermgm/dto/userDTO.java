package com.usermgm.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userDTO {
	
	@NotNull(message="id cannot be null")
	private int userId;
	@NotEmpty(message ="username cannot be empty")
	private String userName;
	@Pattern(regexp="[0-9]{10}")
	private String userPhone;
	@Email(message ="Email should be valid")
	private String userEmail;
	@Pattern(regexp="[a-zA-Z0-9@#&!]{5,15}")
	private String userPassword;

}
