package com.example.resume_system.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.resume_system.Entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
	List<Skill>findByUserId(Long userId);

}
