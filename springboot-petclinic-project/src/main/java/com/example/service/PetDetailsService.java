package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.PetDetails;
import com.example.repository.PetDetailsRepository;

@Service
public class PetDetailsService {
	
	@Autowired
	private PetDetailsRepository repo;
	
	
	public List<PetDetails> listAll(){
		
		return repo.findAll();
	}
	
	public void save(PetDetails savePet) {
		
		repo.save(savePet);
	}
	
	public PetDetails get(long id) {
		
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		
		repo.deleteById(id);
	}
}
