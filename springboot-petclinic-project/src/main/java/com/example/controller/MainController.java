package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Appointment;
import com.example.model.PetDetails;
import com.example.model.Veterinarian;
import com.example.service.AppointmentService;
import com.example.service.PetDetailsService;
import com.example.service.VeterinarianService;


@Controller
public class MainController {
	
	@Autowired
	PetDetailsService petSer;
	
	@Autowired
	VeterinarianService vetSer;
	
	@Autowired
	AppointmentService appSer;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home(Model model) 
	{
		
		List<PetDetails> petDetails = petSer.listAll();
		System.out.println("Size = "+petDetails.size());
		
		model.addAttribute("petDetails", petDetails);
		
		List<Veterinarian> vetDetails = vetSer.listAll();
		model.addAttribute("vetDetails", vetDetails);
		
		return "petDetailspage";
//		return "index";
	}
	
	@GetMapping("/bookAppointment")
	public String book(Model model) {
		
		List<PetDetails> pets = petSer.listAll();
		model.addAttribute("pets", pets);
		
		List<Veterinarian> vets = vetSer.listAll();
		model.addAttribute("vets", vets);
		return "bookAppoitnment";
	}
	
	@GetMapping("/showAppointment1")
	public String show1(Model model) {
		
		List<Appointment> app = appSer.listAll();
		model.addAttribute("app", app);
		
		return "showAppointment";
		
	}
	
	@RequestMapping(value = "/saveAppointment", method = RequestMethod.POST)
	public String saveApp(@ModelAttribute("appointmentDetails") Appointment app) {
		
		System.out.println("Once upon a time:"+app);
		appSer.save(app);
		return "appointmentSuccess";
	}
	
	@RequestMapping(value = "/showAppointment", method = RequestMethod.POST) 
	public String show(Model model) {
		
		List<Appointment> app = appSer.listAll();
		model.addAttribute("app", app);
		
		return "showAppointment";
	}
	
	@RequestMapping("/deleteAppointment/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        appSer.delete(id);
        return "redirect:/showAppointment1";
	}
	
}
