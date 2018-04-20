package isa.projekat.service;

import isa.projekat.model.Sala;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SalaService {
	List<Sala> saleUstanove(Long idUstanove);
	
	@Transactional
	void promeni(Sala sala);
	
	@Transactional
	void dodaj(Sala sala, Long idUstanove);
}
