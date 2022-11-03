package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointment", schema = "targetSchemaName")
public class Appointment {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ownername")
	private String ownername;
	
	@Column(name = "petname")
	private String petname;
	
	@Column(name = "phonenumber")
	private String phonenumber;
	
	@Column(name = "vetname")
	private String vetname;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "time")
	private String time;
	
	public Appointment() {
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	public String getPetname() {
		return petname;
	}
	public void setPetname(String petname) {
		this.petname = petname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getVetname() {
		return vetname;
	}
	public void setVetname(String vetname) {
		this.vetname = vetname;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", ownername=" + ownername + ", petname=" + petname + ", phonenumber="
				+ phonenumber + ", vetname=" + vetname + ", date=" + date + ", time=" + time + "]";
	}
	
	
	
}
