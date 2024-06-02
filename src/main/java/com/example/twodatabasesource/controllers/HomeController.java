
package com.example.twodatabasesource.controllers;

import com.example.twodatabasesource.datasource.source2.entities.User;
import com.example.twodatabasesource.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Ramesh Fadatare
 *
 */
@RestController
@RequestMapping(path="base")
public class HomeController
{
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/app/users")
	public String getUsers()
	{
		User user = new User();
		user.setName("eton1");
		user.setEmail("john@gmail.com");
		userService.persistUsers2(user);
		return "users";
	}
}
