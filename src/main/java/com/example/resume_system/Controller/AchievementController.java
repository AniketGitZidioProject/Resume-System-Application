package com.example.resume_system.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.resume_system.Entity.Achievement;
import com.example.resume_system.Service.AchievementService;

@RestController
@RequestMapping("/api/achievement")
public class AchievementController {
	
	@Autowired
	private AchievementService achievementService;
	
	@PostMapping("/create/{userId}")
	public ResponseEntity<Achievement> createAchievement(@PathVariable Long userId, @RequestBody Achievement achievement){
		return ResponseEntity.ok(achievementService.createAchievement(userId, achievement));
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Achievement>> getAchievementsByUser(@PathVariable Long userId){
		return ResponseEntity.ok(achievementService.getAchievementsByUser(userId));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Achievement> updateAchievement(@PathVariable Long id, @RequestBody Achievement achievement){
		return ResponseEntity.ok(achievementService.updateAchievement(id, achievement));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAchievement(@PathVariable Long id){
		achievementService.deleteAchievement(id);
		return ResponseEntity.ok("Achievement Deleted Succesfully");
	}

}
