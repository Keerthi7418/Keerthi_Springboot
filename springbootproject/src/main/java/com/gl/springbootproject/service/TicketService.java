package com.gl.springbootproject.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.springbootproject.Ticket.TicketTracker;
import com.gl.springbootproject.repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	TicketRepository repo;
	

	public void add(TicketTracker ticketTracker) {
		repo.save(ticketTracker);
	}

	public void update(TicketTracker ticketTracker) {
		repo.save(ticketTracker);
	}

	public List<TicketTracker> getAll() {
		return repo.findAll();
	}

	public TicketTracker getById(int id) {
		Optional<TicketTracker> ticketOptional = repo.findById(id);
		TicketTracker temp = null;
		if (ticketOptional.get() != null) {
			temp = ticketOptional.get();
		}
		return temp;
	}

	public void delete(TicketTracker ticketTracker)

	{
		repo.delete(ticketTracker);
	}
	
}
