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

import com.example.resume_system.Entity.Course;
import com.example.resume_system.Service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/create/{userId}")
	public ResponseEntity<Course> createCourse(@PathVariable Long userId, @RequestBody Course course){
		return ResponseEntity.ok(courseService.createCourse(userId, course));
	}
	
	@GetMapping("user/{userId}")
	public ResponseEntity<List<Course>> getCoursesByUser(@PathVariable Long userId){
		return ResponseEntity.ok(courseService.getCoursesByUser(userId));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course){
		return ResponseEntity.ok(courseService.updateCourse(id, course));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable Long id){
		courseService.deleteCourse(id);
		return ResponseEntity.ok("Course deleted Successfully");
	}
	

}
