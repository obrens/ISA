package isa.projekat.service;

import isa.projekat.model.DTO.RekvizitDTO;
import isa.projekat.model.Rekvizit;
import org.springframework.transaction.annotation.Transactional;

public interface RekvizitService {
	RekvizitDTO rekvizitZaSlanje(Rekvizit rekvizit);
	
	Rekvizit rekvizitZaPrimanje(RekvizitDTO rekvizitDTO);
	
	@Transactional
	void izmeniRekvizit(RekvizitDTO rekvizitDTO);
	
	Rekvizit napraviRekvizit(RekvizitDTO rekvizitDTO);
	
	void izbrisiRekvizit(Long id);
}
