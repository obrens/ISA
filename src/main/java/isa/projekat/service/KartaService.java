package isa.projekat.service;

import isa.projekat.model.DTO.KartaDTO;
import isa.projekat.model.Karta;
import isa.projekat.repository.KartaRepository;
import isa.projekat.repository.KorisnikRepository;
import isa.projekat.repository.ProjekcijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class KartaService {
	@Autowired
	ProjekcijaRepository projekcijaRepository;
	
	@Autowired
	KorisnikRepository korisnikRepository;
	
	@Autowired
	KartaRepository kartaRepository;
	
	public List<KartaDTO> karteZaProjekciju(Long id){
		List<Karta> karte = kartaRepository.findByProjekcija(projekcijaRepository.findById(id));
		ArrayList<KartaDTO> karteDTO = new ArrayList<>();
		
		for (Karta karta : karte) {
			KartaDTO kartaDTO = new KartaDTO();
			kartaDTO.setId(karta.getId());
			kartaDTO.setRed(karta.getRed());
			kartaDTO.setSediste(karta.getSediste());
			kartaDTO.setRezervisana(karta.isRezervisana());
			karteDTO.add(kartaDTO);
		}
		
		return karteDTO;
	}
	
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public synchronized boolean rezervisiKartu(Long kartaId, Long korisnikId) {
		Karta karta = kartaRepository.findOne(kartaId);
		if (karta.isRezervisana()){
			return false;
		}
		else{
			karta.setRezervisana(true);
			karta.setKupac(korisnikRepository.findOne(korisnikId));
			kartaRepository.save(karta);
			return true;
		}
	}
}
