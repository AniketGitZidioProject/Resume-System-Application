package com.example.resume_system.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.resume_system.Entity.User;
import com.example.resume_system.Service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;  // ✅ must be autowired
	
	@GetMapping("/{id}")
	public ResponseEntity<User>getUserById(@PathVariable Long id){
		User user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User>updateUser(@PathVariable Long id, @RequestBody User user){
		return ResponseEntity.ok(userService.updateUser(id, user));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		return ResponseEntity.ok("User deleted successfully");
	}

}
