package com.example.resume_system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.resume_system.Entity.Achievement;
import com.example.resume_system.Entity.User;
import com.example.resume_system.Repository.AchievementRepository;
import com.example.resume_system.Repository.UserRepository;

@Service  // ✅ This is the key fix!
public class AchievementService {
	
	@Autowired
	private AchievementRepository achievementRepository;
	
	@Autowired
	private UserRepository  userRepository;
	
	public Achievement createAchievement(Long userId, Achievement achievement) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User Not Found"));
		achievement.setUser(user);
		return achievementRepository.save(achievement);
	}
	
	public List<Achievement>getAchievementsByUser(Long userId){
		return achievementRepository.findByUserId(userId);
	}
	
	public Achievement updateAchievement(Long id, Achievement updatedAchievement) {
		Achievement achievement = achievementRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Achievement not found"));
		
		achievement.setTitle(updatedAchievement.getTitle());
		achievement.setDescription(updatedAchievement.getDescription());
		achievement.setDate(updatedAchievement.getDate());
		achievement.setVerificationUrl(updatedAchievement.getVerificationUrl());
		
		return achievementRepository.save(achievement);
	}
	
	public void deleteAchievement(Long id) {
		Achievement achievement = achievementRepository.findById(id)
				.orElseThrow(() ->new RuntimeException("Achievement Not Found"));
		achievementRepository.delete(achievement);
	}
	 // ✅ New method to delete all projects by userId
		public void deleteAchievementByUser(Long userId) {
			List<Achievement>achievement = achievementRepository.findByUserId(userId);
			achievementRepository.deleteAll(achievement);
		}
}
