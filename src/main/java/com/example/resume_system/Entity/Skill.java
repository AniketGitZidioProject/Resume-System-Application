package com.example.resume_system.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)  // or EAGER if you want
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(nullable = false)
	private String name;
	
	private String level; //Beginner, Intermediate, Advanced
	
	private int endorsements;
	
	//Constructors
	//Default Constructor
	public Skill() {}
	
	//Parameterized Constructor
	public Skill(Long id,User user,String name, String level, int endorsements) {
		this.id = id;
		this.user = user;
		this.level = level;
		this.endorsements = endorsements;
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

	public int getEndorsements() {
		return endorsements;
	}

	public void setEndorsements(int endorsements) {
		this.endorsements = endorsements;
	}
	

	

}
