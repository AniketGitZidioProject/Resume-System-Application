package com.example.resume_system.DTO;

import java.util.Date;

public class CourseDTO {
	
	public Long id;
	public String title;
	public String institution;
	public Date completionDate;
	public String certificateUrl;
	public Long userId;
	
	public CourseDTO(Long id,String title,String institution,Date completionDate,String certificateUrl,Long userId) {
		this.id = id;
		this.title = title;
		this.institution = institution;
		this.completionDate = completionDate;
		this.certificateUrl = certificateUrl;
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

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public String getCertificateUrl() {
		return certificateUrl;
	}

	public void setCertificateUrl(String certificateUrl) {
		this.certificateUrl = certificateUrl;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
	

}
