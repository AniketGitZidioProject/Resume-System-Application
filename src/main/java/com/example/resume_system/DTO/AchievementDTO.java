package com.example.resume_system.DTO;

import java.util.Date;

public class AchievementDTO {
	
	public Long id;
	public String title;
	public String description;
	public Date date;
	public String verificationUrl;
	public Long userId;
	
	public AchievementDTO(Long id,String title,String description,Date date,String verificationUrl,Long userId) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.verificationUrl = verificationUrl;
		this.userId = userId;
	}
	
	//Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getVerificationUrl() {
		return verificationUrl;
	}

	public void setVerificationUrl(String verificationUrl) {
		this.verificationUrl = verificationUrl;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
	

}
