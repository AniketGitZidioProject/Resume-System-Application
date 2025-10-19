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

import com.example.resume_system.Entity.Skill;
import com.example.resume_system.Service.SkillService;

@RestController
@RequestMapping("/api/skills")
public class SkillController {
	
	@Autowired
	private SkillService skillService;
	
	@PostMapping("/create/{userId}")
	public ResponseEntity<Skill> createSkill(@PathVariable Long userId, @RequestBody Skill skill){
	    Skill newSkill = skillService.createSkill(userId, skill);
	    return ResponseEntity.ok(newSkill);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Skill>> getSkillsByUser(@PathVariable Long userId){
	    List<Skill> skills = skillService.getSkillsByUser(userId);
	    return ResponseEntity.ok(skills);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Skill> updateSkill(@PathVariable Long id, @RequestBody Skill skill){
		return ResponseEntity.ok(skillService.updateSkill(id, skill));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteSkill(@PathVariable Long id){
		skillService.deleteSkill(id);
		return ResponseEntity.ok("Skill Deleted Successfully");
	}

}
