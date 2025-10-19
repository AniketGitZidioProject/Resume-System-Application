package com.example.resume_system.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.resume_system.Entity.User;
import com.example.resume_system.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	// ✅ Get user by ID
	public User getUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User Not Found"));
	}
	// ✅ Update user details
	public User updateUser(Long id, User updatedUser) {
		User user = getUserById(id);
		user.setName(updatedUser.getName());
		user.setEmail(updatedUser.getEmail());
		user.setPassword(updatedUser.getPassword());
		return userRepository.save(user);
	}
	
	// ✅ Delete user properly
	public void deleteUser(Long id) {
		User user = getUserById(id); // verify user exists
		userRepository.delete(user); // perform deletion
	}
	
	// ✅ Find user by email
	public Optional<User>findByEmail(String email){
		return userRepository.findByEmail(email);
	}

}
