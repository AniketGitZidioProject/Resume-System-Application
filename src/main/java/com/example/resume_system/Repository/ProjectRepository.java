package com.example.resume_system.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.resume_system.Entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{
	List<Project>findByUserId(Long userId);

}
