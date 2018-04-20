package isa.projekat.service;

import isa.projekat.model.DTO.KorisnikDTO;
import isa.projekat.model.DTO.PrijateljDTO;
import isa.projekat.model.Korisnik;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface KorisnikService {
	KorisnikDTO korisnikDTO(Korisnik korisnik);
	
	List<PrijateljDTO> prijateljiINeprijatelji(Korisnik korisnik);
	
	List<PrijateljDTO> zahtevni(Korisnik korisnik);
	
	Korisnik napraviKorisnika(KorisnikDTO korisnikDTO);
	
	Korisnik zahtevamPrijatelja(Long id, Long idPrijatelja);
	
	@Transactional
	void izmeniKorisnika(KorisnikDTO korisnikDTO);
	
	@Transactional
	void gubimPrijatelja(Long idPrijateljstva);
	
	@Transactional
	Korisnik prihvatamTePrijateljuOberucke(Long prijateljstvoId);
}
