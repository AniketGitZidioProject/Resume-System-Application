package com.example.resume_system.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.resume_system.Entity.Achievement;
import com.example.resume_system.Entity.Course;
import com.example.resume_system.Entity.Project;
import com.example.resume_system.Entity.Skill;
import com.example.resume_system.Entity.User;
import com.example.resume_system.Service.AchievementService;
import com.example.resume_system.Service.CourseService;
import com.example.resume_system.Service.ProjectService;
import com.example.resume_system.Service.SkillService;
import com.example.resume_system.Service.UserService;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private AchievementService achievementService;
	
	@Autowired
	private SkillService skillService;
	
	@GetMapping("/{userId}")
	public ResponseEntity<Map<String, Object>> getFullResume(@PathVariable Long userId){
		User user = userService.getUserById(userId);
		List<Project>projects = projectService.getProjectsByUser(userId);
		List<Course> course = courseService.getCoursesByUser(userId);
		List<Achievement> achievement = achievementService.getAchievementsByUser(userId);
		List<Skill> skills = skillService.getSkillsByUser(userId);
		
		Map<String, Object> resume = new HashMap<>();
		resume.put("user", user);
		resume.put("projects", projects);
		resume.put("courses", course);
		resume.put("achievements", achievement);
		resume.put("skills", skills);
		
		return ResponseEntity.ok(resume);
		
	}
	
	// DELETE full resume
	@DeleteMapping("/{userId}")
	public ResponseEntity<Map<String, String>> deleteFullResume(@PathVariable Long userId) {
	    // Delete associated entities first
	    projectService.deleteProjectsByUser(userId);
	    courseService.deleteCoursesByUser(userId);
	    achievementService.deleteAchievementByUser(userId);
	    skillService.deleteSkillByUser(userId);

	    // Delete the user
	    userService.deleteUser(userId);

	    // Prepare Response
	    Map<String, String> response = new HashMap<>();
	    response.put("message", "Full resume and all associated data deleted successfully for userId:" + userId);
	    return ResponseEntity.ok(response);
	}

}
