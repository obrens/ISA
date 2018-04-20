package isa.projekat.service;

import isa.projekat.model.Sala;
import isa.projekat.repository.SalaRepository;
import isa.projekat.repository.UstanovaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	public void promeni(Sala sala) {
		Sala moja = salaRepository.findOne(sala.getId());
		moja.setNazivSale(sala.getNazivSale());
		moja.setBrojRedova(sala.getBrojRedova());
		moja.setBrojKolona(sala.getBrojKolona());
		salaRepository.save(moja);
	}
	
	@Transactional
	public void dodaj(Sala sala, Long idUstanove) {
		Sala moja = new Sala();
		moja.setUstanova(ustanovaRepository.findOne(idUstanove));
		moja.setNazivSale(sala.getNazivSale());
		moja.setBrojRedova(sala.getBrojRedova());
		moja.setBrojKolona(sala.getBrojKolona());
		salaRepository.save(moja);
	}
}
