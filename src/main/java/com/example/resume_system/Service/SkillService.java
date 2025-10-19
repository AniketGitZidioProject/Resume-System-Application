package com.example.resume_system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.resume_system.Entity.Skill;
import com.example.resume_system.Entity.User;
import com.example.resume_system.Repository.SkillRepository;
import com.example.resume_system.Repository.UserRepository;

@Service
public class SkillService {
	
	@Autowired
	private SkillRepository skillRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Skill createSkill(Long userId, Skill skill) {
		User user  = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User Not Found"));
		skill.setUser(user);// ✅ Important
		return skillRepository.save(skill);
	}
	// ✅ Get all skills of a user
	public List<Skill>getSkillsByUser(Long userId){
		return skillRepository.findByUserId(userId);
	}
	// ✅ Update an existing skill
	public Skill updateSkill(Long id,Skill updatedSkill) {
		Skill skill = skillRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Skill Not Found"));
		
		skill.setName(updatedSkill.getName());
		skill.setLevel(updatedSkill.getLevel());
		skill.setEndorsements(updatedSkill.getEndorsements());
		
		return skillRepository.save(skill);
	}
	
	 // ✅ Delete a single skill by its ID
	public void deleteSkill(Long id) {
		Skill skill = skillRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Skill Not Found"));
		skillRepository.delete(skill);
	}
	
	 // ✅ New method to delete all projects by userId /  // ✅ Delete all skills of a user
		public void deleteSkillByUser(Long userId) {
			List<Skill>skills = skillRepository.findByUserId(userId);
			skillRepository.deleteAll(skills);
		}

}
