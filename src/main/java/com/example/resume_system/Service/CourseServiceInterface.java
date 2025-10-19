package com.example.resume_system.Service;

import java.util.List;

import com.example.resume_system.Entity.Course;

public interface CourseServiceInterface {
	Course createCourse(Long userId, Course course);
	List<Course> getCoursesByUser(Long userId);
	void deleteCourse(Long id);
	//Course updateCourse(Long id, Course updatedCourse);
	Course updatedCourse(Long id, Course updatedCourse);
	Course updateCourse(Long id, Course updatedCourse);
	 

}
