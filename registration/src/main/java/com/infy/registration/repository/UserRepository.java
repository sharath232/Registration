package com.infy.registration.repository;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.infy.registration.model.User;

@Repository
public class UserRepository 
{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int saveUser(User user)
	{
		jdbcTemplate.update("insert into user (email, mobile, passportNumber, userName, password)" + "values(?,  ?, ?, ?, ?)",
		new Object[] {
				user.getEmail(), user.getMobile(), user.getPassportNumber(), user.getUserName(), user.getPassword()
		});
		
		Random rnd = new Random();
		return 100000 + rnd.nextInt(900000);
	}
}
