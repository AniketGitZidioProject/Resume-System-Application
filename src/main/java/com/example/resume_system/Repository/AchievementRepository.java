package com.example.resume_system.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.resume_system.Entity.Achievement;

public interface AchievementRepository extends JpaRepository<Achievement, Long>{
	List<Achievement>findByUserId(Long userId);

}
