package com.gl.springbootproject.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.gl.springbootproject.Ticket.TicketTracker;
import com.gl.springbootproject.service.TicketService;


@Controller
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	@RequestMapping("/home")
	public String homepage() {
		return "homepage";
	}
	
	@RequestMapping("/showticket")
	public String showTicket(Model value) {

		List<TicketTracker> ticket = ticketService.getAll();

		value.addAttribute("values", ticket);

		return "showticket";

	}
	
	@RequestMapping("/addticketform")
	public String addTicketForm() {
		
		return "addticketform";
	}

	@PostMapping("/addticket")
	public String addticket(@RequestParam int id, @RequestParam String ticketTitle, @RequestParam String ticketShortDescription,
			@RequestParam String ticketCreatedOn, Model value) {

		TicketTracker addticket = new TicketTracker(id, ticketTitle, ticketShortDescription, ticketCreatedOn);
		ticketService.add(addticket);
		
		List<TicketTracker> ticket = ticketService.getAll();
		value.addAttribute("values", ticket);
		return "showticket";
	}
	
	@GetMapping("/updateticket")
	public String updateTicket(@RequestParam int id, Model model) {
	    TicketTracker ticket = ticketService.getById(id);
	    model.addAttribute("ticket", ticket); 
	    return "updateticket";    
	}

	@PostMapping("/updated")
	public String updatedTicket(@RequestParam int id, @RequestParam String ticketTitle, @RequestParam String ticketShortDescription,
			@RequestParam String ticketCreatedOn, Model value) {
		TicketTracker ticket = new TicketTracker(id, ticketTitle, ticketShortDescription, ticketCreatedOn);
		ticketService.update(ticket);
		value.addAttribute("Ticket", ticket);
		
		return "redirect:showticket";
		
	}

	@RequestMapping("/deleteTicket")
	public String deleteTicket(@RequestParam int id,Model value) {

		TicketTracker delete = new TicketTracker(id, "", "", "");

		ticketService.delete(delete);
		
		List<TicketTracker> ticket = ticketService.getAll();

		value.addAttribute("values", ticket);
		
		return "showticket";
	}
	
	@RequestMapping("/viewticket")
	public String viewTicket(Model value) {

		List<TicketTracker> ticket = ticketService.getAll();

		value.addAttribute("values", ticket);

		return "viewticket";

	}
	
}
