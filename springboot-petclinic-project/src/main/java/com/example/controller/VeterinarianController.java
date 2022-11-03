package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.service.VeterinarianService;
import com.example.model.Veterinarian;

import java.util.*;

@Controller
public class VeterinarianController {
	
	@Autowired
	VeterinarianService vetSer;
	
	
	@GetMapping("/active")
	public String returnHomePage() {
        
        return "vetDetails";
    }
	
//	@GetMapping("/vets")
//	public String viewHomePage(Model model) {
//		
//		List<Veterinarian> vetDetails = vetSer.listAll();
//		model.addAttribute("vetDetails", vetDetails);
//		return "vetDetails";
//	}
	
	@GetMapping("/newVet")
	    public String add(Model model) {
	        model.addAttribute("vets", new Veterinarian());
	        return "newVet";
	}
	
	@RequestMapping(value = "/saveVet", method = RequestMethod.POST)
    public String saveVet(@ModelAttribute("vets") Veterinarian vets) {
        vetSer.save(vets);
        System.out.println("Helo");
        return "redirect:/vets";
    }
	
	@RequestMapping("/editVet/{id}")
    public ModelAndView showEditVetPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("newVet");
        Veterinarian vets = vetSer.get(id);
        mav.addObject("vets", vets);
        return mav;     
    }
	
	@RequestMapping("/deleteVet/{id}")
	    public String deleteVet(@PathVariable(name = "id") int id) {
	        vetSer.delete(id);
	        return "redirect:/vets";
	}
}
