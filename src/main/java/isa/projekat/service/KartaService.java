package isa.projekat.service;

import isa.projekat.model.DTO.KartaDTO;
import isa.projekat.model.DTO.RezervacijaDTO;
import isa.projekat.model.Karta;
import isa.projekat.model.Korisnik;
import isa.projekat.model.Projekcija;
import isa.projekat.model.Ustanova;
import isa.projekat.repository.KartaRepository;
import isa.projekat.repository.KorisnikRepository;
import isa.projekat.repository.ProjekcijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
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
	
	public List<RezervacijaDTO> rezervacijeKorisnika(Long korisnikId){
		Korisnik korisnik = korisnikRepository.findOne(korisnikId);
		List<Karta> karte = kartaRepository.findByKorisnik(korisnik);
		List<RezervacijaDTO> rezervacije = new ArrayList<>();
		for (Karta karta : karte) {
			Date datum = karta.getProjekcija().getDatum();
			boolean prosla = Instant.now().isAfter(datum.toInstant());
			if (!prosla) {
				rezervacije.add(rezervacijaOdKarte(karta));
			}
		}
		return rezervacije;
	}
	
	public List<RezervacijaDTO> poseteKorisnika(Long korisnikId) {
		Korisnik korisnik = korisnikRepository.findOne(korisnikId);
		List<Karta> karte = kartaRepository.findByKorisnik(korisnik);
		List<RezervacijaDTO> posete = new ArrayList<>();
		for (Karta karta : karte) {
			Date datum = karta.getProjekcija().getDatum();
			boolean prosla = Instant.now().isAfter(datum.toInstant());
			if (prosla) {
				posete.add(rezervacijaOdKarte(karta));
			}
		}
		return posete;
	}
	
	private RezervacijaDTO rezervacijaOdKarte(Karta karta){
		RezervacijaDTO rezervacija = new RezervacijaDTO();
		//region Ajdijevi
		rezervacija.setKartaId(karta.getId());
		Projekcija projekcija = karta.getProjekcija();
		rezervacija.setProjekcijaId(projekcija.getId());
		Ustanova ustanova = projekcija.getDelo().getUstanova();
		rezervacija.setUstanovaId(ustanova.getId());
		//endregion
		//region Nazivi
		rezervacija.setNazivDela(projekcija.getDelo().getNaziv());
		rezervacija.setNazivSale(projekcija.getSala().getNazivSale());
		rezervacija.setNazivUstanove(ustanova.getNaziv());
		//endregion
		//region Kada
		rezervacija.setDatum(projekcija.getDatum());
		rezervacija.setVreme(projekcija.getVreme());
		//endregion
		//region Gde
		rezervacija.setRed(karta.getRed());
		rezervacija.setSediste(karta.getSediste());
		//endregion
		//region Ocene
		rezervacija.setOcenjenAmbijent(karta.isOcenjenAmbijent());
		rezervacija.setOcenjenaProjekcija(karta.isOcenjenaProjekcija());
		rezervacija.setOcenaAmbijenta(karta.getOcenaAmbijenta());
		rezervacija.setOcenaProjekcije(karta.getOcenaProjekcije());
		//endregion
		return rezervacija;
	}
	
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public synchronized void otkazi(Long id) {
		Karta karta = kartaRepository.findOne(id);
		karta.setRezervisana(false);
		karta.setKupac(null);
		kartaRepository.save(karta);
	}
}
