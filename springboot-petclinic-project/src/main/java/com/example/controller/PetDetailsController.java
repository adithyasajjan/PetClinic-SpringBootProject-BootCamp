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

import com.example.service.PetDetailsService;

import java.util.*;

import com.example.model.PetDetails;

@Controller
public class PetDetailsController {

	@Autowired
	PetDetailsService petSer;
	
//	@GetMapping("/pets")
//	public String viewHomePage(Model model) {
//		
//		List<PetDetails> petDetails = petSer.listAll();
//		System.out.println("Size = "+petDetails.size());
//		
//		model.addAttribute("petDetails", petDetails);
//		return "petDetailspage";
//	}
	  
	
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("details", new PetDetails());
        return "new";
    }
   
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePet(@ModelAttribute("details") PetDetails details) {
        petSer.save(details);
        return "redirect:/";
    }
    
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPetPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        PetDetails details = petSer.get(id);
        mav.addObject("details", details);
        return mav;     
    }
    
    @RequestMapping("/delete/{id}")
    public String deletePet(@PathVariable(name = "id") int id) {
        petSer.delete(id);
        return "redirect:/";
    }
    
}
