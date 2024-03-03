package com.gl.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.springbootproject.Ticket.TicketTracker;

public interface TicketRepository extends JpaRepository<TicketTracker,Integer> {
	

}
