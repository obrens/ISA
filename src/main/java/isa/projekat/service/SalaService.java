package isa.projekat.service;

import isa.projekat.model.Sala;
import isa.projekat.repository.SalaRepository;
import isa.projekat.repository.UstanovaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {
	@Autowired
	UstanovaRepository ustanovaRepository;
	
	@Autowired
	SalaRepository salaRepository;
	
	public List<Sala> saleUstanove(Long idUstanove) {
		List<Sala> sale = salaRepository.findByUstanova(ustanovaRepository.findOne(idUstanove));
		return sale;
	}
}
