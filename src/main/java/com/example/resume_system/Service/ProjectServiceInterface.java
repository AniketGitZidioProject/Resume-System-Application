package com.example.resume_system.Service;

import java.util.List;

import com.example.resume_system.Entity.Project;

public interface ProjectServiceInterface {
	Project createProject(Long userId, Project project);
    List<Project> getProjectsByUser(Long userId);
    Project updateProject(Long id, Project project);
    void deleteProject(Long id);

    // Add this
    void deleteProjectsByUser(Long userId);

}
