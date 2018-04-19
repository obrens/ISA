package isa.projekat.service;

import isa.projekat.model.Delo;
import isa.projekat.repository.DeloRepository;
import isa.projekat.repository.UstanovaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeloService {
	@Autowired
	UstanovaRepository ustanovaRepository;
	
	@Autowired
	DeloRepository deloRepository;
	
	public List<Delo> delaUstanove(Long idUstanove) {
		List<Delo> dela = deloRepository.findByUstanova(ustanovaRepository.findOne(idUstanove));
		return dela;
	}
}
