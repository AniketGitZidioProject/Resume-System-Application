package com.example.resume_system.DTO;

public class SkillDTO {
	
	public Long id;
	public String name;
	public String level;
	public String endorsements;
	public Long userId;
	
	public SkillDTO( Long id,String name,String level,String endorsements,Long userId) {
		this.id =id;
		this.name = name;
		this.level = level;
		this.endorsements = endorsements;
		this.userId = userId;
	}
	
	//Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getEndorsements() {
		return endorsements;
	}

	public void setEndorsements(String endorsements) {
		this.endorsements = endorsements;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	

}
