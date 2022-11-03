package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Veterinarian;
import com.example.repository.VeterinarianRepository;

@Service
public class VeterinarianService {
	
	@Autowired
	private VeterinarianRepository repo;
	
	public List<Veterinarian> listAll(){
		
		return repo.findAll();
	}
	
	public void save(Veterinarian vet) {
		
		repo.save(vet);
	}
	
	public Veterinarian get(long id) {
		
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		
		repo.deleteById(id);
	}
}
