package isa.projekat.service;

import isa.projekat.model.DTO.KartaDTO;
import isa.projekat.model.DTO.KartaNaPopustuDTO;
import isa.projekat.model.DTO.PopustDTO;
import isa.projekat.model.DTO.RezervacijaDTO;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface KartaService {
	List<KartaDTO> karteZaProjekciju(Long id);
	
	@Transactional(isolation = Isolation.SERIALIZABLE)
	boolean rezervisiKartu(Long kartaId, Long korisnikId);
	
	List<RezervacijaDTO> rezervacijeKorisnika(Long korisnikId);
	
	List<RezervacijaDTO> poseteKorisnika(Long korisnikId);
	
	@Transactional(isolation = Isolation.SERIALIZABLE)
	void otkazi(Long id);
	
	List<KartaNaPopustuDTO> dostupniPopusti(Long ustanovaId);
	
	@Transactional(isolation = Isolation.SERIALIZABLE)
	KartaNaPopustuDTO dodajPopust(PopustDTO popustDTO);
	
	@Transactional(isolation = Isolation.SERIALIZABLE)
	void obrisiPopust(Long idPopusta);
	
	@Transactional(isolation = Isolation.SERIALIZABLE)
	boolean brzoRezervisiKartu(Long popustId, Long korisnikId);
	
	@Transactional
	void oceniProjekciju(RezervacijaDTO rezervacijaDTO);
	
	@Transactional
	void oceniAmbijent(RezervacijaDTO rezervacijaDTO);
}
