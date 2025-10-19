package com.example.resume_system.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.resume_system.Entity.Project;
import com.example.resume_system.Service.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // Create project for a user
    @PostMapping("/create/{userId}")
    public ResponseEntity<Project> createProject(@PathVariable Long userId, @RequestBody Project project) {
        return ResponseEntity.ok(projectService.createProject(userId, project));
    }

    // Get all projects by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Project>> getProjectsByUser(@PathVariable Long userId) {
        List<Project> projects = projectService.getProjectsByUser(userId);
        return ResponseEntity.ok(projects);
    }

    // Update project by project ID
    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) {
        return ResponseEntity.ok(projectService.updateProject(id, project));
    }

    // Delete project by project ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok("Project deleted successfully");
    }

    // Delete all projects for a specific user
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> deleteProjectsByUser(@PathVariable Long userId) {
        projectService.deleteProjectsByUser(userId);
        return ResponseEntity.ok("All projects are deleted for userId: " + userId);
    }
}
