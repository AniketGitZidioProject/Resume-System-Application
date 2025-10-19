package com.example.resume_system.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.resume_system.Entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
	List<Course>findByUserId(Long userId);

}
