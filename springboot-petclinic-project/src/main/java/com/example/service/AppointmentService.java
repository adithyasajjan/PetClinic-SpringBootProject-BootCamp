package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.AppointmentRepository;

import com.example.model.Appointment;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository repo;
	
	public List<Appointment> listAll(){
		
		return repo.findAll();
	}
	
	public void save(Appointment app) {
		
		repo.save(app);
	}
	
	public Appointment get(long id) {
		
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		
		repo.deleteById(id);
	}
	
}
