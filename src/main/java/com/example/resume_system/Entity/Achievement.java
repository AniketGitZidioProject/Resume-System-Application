package com.example.resume_system.Entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "achievements")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Achievement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties("achievements")// 👈 prevents recursion
	private User user;
	
	@Column(nullable = false)
	private String title;
	
	private String verificationUrl;
	
	@Column(nullable = false)
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	
	
	//Constructors
	//Default Constructor
	public Achievement() {}
	
	//Parameterized Constructors
	public Achievement(Long id, User user, String title,String description,Date date,String verificationUrl) {
		this.id = id;
		this.user = user;
		this.title = title;
		this.description = description;
		this.date = date;
		this.verificationUrl = verificationUrl;
	}
	
	//Getters and Setters

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
	
	

}
