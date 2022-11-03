package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "veterinarian", schema = "targetSchemaName")
public class Veterinarian {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "vetname")
	private String vetname;
	
	@Column(name = "qualification")
	private String qualification;
	
	@Column(name = "experience")
	private String experience;
	
	public Veterinarian() {
		
	}

	public Veterinarian(Long id, String vetname, String qualification, String experience) {
		super();
		this.id = id;
		this.vetname = vetname;
		this.qualification = qualification;
		this.experience = experience;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getVetname() {
		return vetname;
	}
	public void setVetname(String vetname) {
		this.vetname = vetname;
	}

	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	
}
