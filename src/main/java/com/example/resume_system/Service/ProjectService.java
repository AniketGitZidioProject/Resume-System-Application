package com.example.resume_system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.resume_system.Entity.Project;
import com.example.resume_system.Entity.User;
import com.example.resume_system.Repository.ProjectRepository;
import com.example.resume_system.Repository.UserRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Project createProject(Long userId, Project project) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User Not Found"));
		project.setUser(user);
		return projectRepository.save(project);
	}
	
	public List<Project> getProjectsByUser(Long userId){
		return projectRepository.findByUserId(userId);
	}
	
	public Project updateProject(Long id, Project updatedProject) {
		Project project = projectRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Project Not Found"));
		
		project.setTitle(updatedProject.getTitle());
		project.setDescription(updatedProject.getDescription());
		project.setStartDate(updatedProject.getStartDate());
		project.setEndDate(updatedProject.getStartDate());
		project.setLink(updatedProject.getLink());
		
		return projectRepository.save(project);
	}
	
	public void deleteProject(Long id) {
		Project project = projectRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Project Not Found"));
		projectRepository.delete(project);
	}
	
	 // ✅ New method to delete all projects by userId
	public void deleteProjectsByUser(Long userId) {
		List<Project>projects = projectRepository.findByUserId(userId);
		projectRepository.deleteAll(projects);
	}

}
