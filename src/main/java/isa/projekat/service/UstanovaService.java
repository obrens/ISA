package isa.projekat.service;

import isa.projekat.model.DTO.UstanovaDTO;
import isa.projekat.model.Ustanova;
import isa.projekat.repository.UstanovaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class UstanovaService {
	@Autowired
	UstanovaRepository ustanovaRepository;
	
	public Ustanova napraviUstanovu(UstanovaDTO ustanovaDTO){
		Ustanova ustanova = new Ustanova();
		ustanova.setNaziv(ustanovaDTO.getNaziv());
		ustanova.setOpis(ustanovaDTO.getOpis());
		ustanova.setAdresa(ustanovaDTO.getAdresa());
		//ustanova.setRepertoar(new HashSet<>());
		//ustanova.setSale(new HashSet<>());
		ustanova.setVrstaUstanove(ustanovaDTO.isVrstaUstanove());
		ustanova.setAdmin(ustanovaDTO.getAdmin());
		ustanovaRepository.save(ustanova);
		return ustanova;
	}
	
	public UstanovaDTO ustanovaZaSlanje(Ustanova ustanova){
		UstanovaDTO ustanovaDTO = new UstanovaDTO();
		ustanovaDTO.setId(ustanova.getId());
		ustanovaDTO.setNaziv(ustanova.getNaziv());
		ustanovaDTO.setAdresa(ustanova.getAdresa());
		ustanovaDTO.setOpis(ustanova.getOpis());
		//TODO Izračunati ocenu
		ustanovaDTO.setOcena(4.5f);
		return ustanovaDTO;
	}
	
	@Transactional
	public void izmeniUstanovu(UstanovaDTO ustanovaDTO){
		Ustanova ustanova = ustanovaRepository.findOne(ustanovaDTO.getId());
		ustanova.setId(ustanovaDTO.getId());
		ustanova.setNaziv(ustanovaDTO.getNaziv());
		ustanova.setOpis(ustanovaDTO.getOpis());
		ustanova.setAdresa(ustanovaDTO.getAdresa());
		ustanovaRepository.save(ustanova);
		//ustanovaRepository.updateUstanova(ustanovaDTO.getId(), ustanovaDTO.getNaziv(), ustanovaDTO.getOpis(), ustanovaDTO.getAdresa());
		//return ustanovaDTO.getId();
	}
	
	public List<Ustanova> bioskopi() {
		List<Ustanova> ustanove = ustanovaRepository.findAll();
		List<Ustanova> bioskopi = new ArrayList<>();
		for (Ustanova ustanova : ustanove){
			if (ustanova.isVrstaUstanove()){
				bioskopi.add(ustanova);
			}
		}
		
		return bioskopi;
	}
	
	public List<Ustanova> pozorista() {
		List<Ustanova> ustanove = ustanovaRepository.findAll();
		List<Ustanova> pozorista = new ArrayList<>();
		for (Ustanova ustanova : ustanove){
			if (!ustanova.isVrstaUstanove()){
				pozorista.add(ustanova);
			}
		}
		
		return pozorista;
	}
}
