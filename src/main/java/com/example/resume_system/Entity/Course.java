package com.example.resume_system.Entity;

import java.util.Date;

import jakarta.persistence.*;
@Entity
@Table(name = "courses")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Column(nullable = false)
	private String title;
	
	private String institution;
	
	@Temporal(TemporalType.DATE)
	private Date completionDate;
	
	private String certificateUrl;
	
	//Contructors
	//Default Constructor
	public Course() {}
	
	//Parameterized Constructor
	public Course(Long id,User user, String title,String institution, Date completionDate, String certificateUrl) {
		this.id = id;
		this.user = user;
		this.title = title;
		this.institution = institution;
		this.completionDate = completionDate;
		this.certificateUrl = certificateUrl;
	}
	
	//Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	
	
	

}
