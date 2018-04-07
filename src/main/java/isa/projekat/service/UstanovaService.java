package isa.projekat.service;

import isa.projekat.model.DTO.UstanovaDTO;
import isa.projekat.model.Ustanova;
import isa.projekat.repository.UstanovaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UstanovaService {
	@Autowired
	UstanovaRepository ustanovaRepository;
	
	public Ustanova napraviUstanovu(UstanovaDTO ustanovaDTO){
		Ustanova ustanova = new Ustanova();
		ustanova.setNaziv(ustanovaDTO.getNaziv());
		ustanova.setOpis(ustanovaDTO.getOpis());
		ustanova.setAdresa(ustanovaDTO.getAdresa());
		ustanova.setRepertoar(new HashSet<>());
		ustanova.setSale(new HashSet<>());
		ustanova.setVrstaUstanove(true);
		ustanovaRepository.save(ustanova);
		return ustanova;
	}
}
