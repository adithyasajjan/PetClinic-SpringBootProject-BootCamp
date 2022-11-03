package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "petdetails", schema = "targetSchemaName")

public class PetDetails {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "petname")
	private String petname;
	
	@Column(name = "pettype")
	private String pettype;
	
	public PetDetails() {
		
	}

	public PetDetails(Long id, String petname, String pettype) {
		super();
		this.id = id;
		this.petname = petname;
		this.pettype = pettype;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getPetname() {
		return petname;
	}
	public void setPetname(String petname) {
		this.petname = petname;
	}

	public String getPettype() {
		return pettype;
	}
	public void setPettype(String pettype) {
		this.pettype = pettype;
	}
	
}
