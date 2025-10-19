package com.example.resume_system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.resume_system.Entity.Course;
import com.example.resume_system.Entity.User;
import com.example.resume_system.Repository.CourseRepository;
import com.example.resume_system.Repository.UserRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Course createCourse(Long userId, Course course) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User Not Found"));
		course.setUser(user);
		return courseRepository.save(course);
	}
	
	public List<Course> getCoursesByUser(Long userId){
		return courseRepository.findByUserId(userId);
	}
	
	public Course updateCourse(Long id, Course updatedCourse) {
		Course course = courseRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Course Not Found"));
		
		course.setTitle(updatedCourse.getTitle());
		course.setInstitution(updatedCourse.getInstitution());
		course.setCompletionDate(updatedCourse.getCompletionDate());
		course.setCertificateUrl(updatedCourse.getCertificateUrl());
		
		return courseRepository.save(course);
	}
	
	public void deleteCourse(Long id) {
		Course course = courseRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Course Not Found"));
		courseRepository.delete(course);
	}
	
	 // ✅ New method to delete all projects by userId
		public void deleteCoursesByUser(Long userId) {
			List<Course>course = courseRepository.findByUserId(userId);
			courseRepository.deleteAll(course);
		}

}
