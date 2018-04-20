package isa.projekat.service;

import isa.projekat.model.*;
import isa.projekat.model.DTO.*;
import isa.projekat.repository.KartaNaPopustuRepository;
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
import java.util.HashMap;
import java.util.List;

@Service
public class KartaServiceImpl implements KartaService {
	@Autowired
	ProjekcijaService projekcijaService;
	
	@Autowired
	ProjekcijaRepository projekcijaRepository;
	
	@Autowired
	KorisnikRepository korisnikRepository;
	
	@Autowired
	KartaRepository kartaRepository;
	
	@Autowired
	KartaNaPopustuRepository kartaNaPopustuRepository;
	
	@Override
	public List<KartaDTO> karteZaProjekciju(Long id) {
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
	
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public synchronized boolean rezervisiKartu(Long kartaId, Long korisnikId) {
		Karta karta = kartaRepository.findOne(kartaId);
		if (karta.isRezervisana()) {
			return false;
		} else {
			karta.setRezervisana(true);
			karta.setKupac(korisnikRepository.findOne(korisnikId));
			kartaRepository.save(karta);
			return true;
		}
	}
	
	@Override
	public List<RezervacijaDTO> rezervacijeKorisnika(Long korisnikId) {
		Korisnik korisnik = korisnikRepository.findOne(korisnikId);
		List<Karta> karte = kartaRepository.findByKupac(korisnik);
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
	
	@Override
	public List<RezervacijaDTO> poseteKorisnika(Long korisnikId) {
		Korisnik korisnik = korisnikRepository.findOne(korisnikId);
		List<Karta> karte = kartaRepository.findByKupac(korisnik);
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
	
	private RezervacijaDTO rezervacijaOdKarte(Karta karta) {
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
	
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public synchronized void otkazi(Long id) {
		Karta karta = kartaRepository.findOne(id);
		karta.setRezervisana(false);
		karta.setKupac(null);
		kartaRepository.save(karta);
	}
	
	//region Popusti
	
	@Override
	public List<KartaNaPopustuDTO> dostupniPopusti(Long ustanovaId) {
		List<ProjekcijaDTO> projekcije = projekcijaService.projekcijeUstanove(ustanovaId);
		HashMap<Long, ProjekcijaDTO> idProjekcije = new HashMap<>();
		List<KartaDTO> karte = new ArrayList<>();
		for (ProjekcijaDTO projekcija : projekcije) {
			idProjekcije.put(projekcija.getId(), projekcija);
			karte.addAll(karteZaProjekciju(projekcija.getId()));
		}
		List<KartaNaPopustuDTO> popusti = new ArrayList<>();
		for (KartaDTO kartaDTO : karte) {
			Karta karta = kartaRepository.findOne(kartaDTO.getId());
			KartaNaPopustu kartaNaPopustu = kartaNaPopustuRepository.findByKarta(karta);
			if (kartaNaPopustu == null) {
				continue;
			}
			if (kartaNaPopustu.isRezervisana()) {
				continue;
			}
			KartaNaPopustuDTO kartaNaPopustuDTO = new KartaNaPopustuDTO();
			
			kartaNaPopustuDTO.setId(kartaNaPopustu.getId());
			kartaNaPopustuDTO.setCena(kartaNaPopustu.getCena());
			kartaNaPopustuDTO.setKarta(kartaDTO);
			ProjekcijaDTO projekcijaDTO = idProjekcije.get(karta.getProjekcija().getId());
			kartaNaPopustuDTO.setProjekcija(projekcijaDTO);
			
			popusti.add(kartaNaPopustuDTO);
		}
		
		return popusti;
	}
	
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public KartaNaPopustuDTO dodajPopust(PopustDTO popustDTO) {
		Karta karta = kartaRepository.findOne(popustDTO.getKartaId());
		karta.setRezervisana(true);
		kartaRepository.save(karta);
		
		KartaNaPopustu kartaNaPopustu = new KartaNaPopustu();
		kartaNaPopustu.setKarta(karta);
		kartaNaPopustu.setCena(popustDTO.getCena());
		kartaNaPopustu.setRezervisana(false);
		kartaNaPopustuRepository.save(kartaNaPopustu);
		
		Projekcija projekcija = karta.getProjekcija();
		
		KartaNaPopustuDTO kartaNaPopustuDTO = new KartaNaPopustuDTO();
		kartaNaPopustuDTO.setId(kartaNaPopustu.getId());
		kartaNaPopustuDTO.setCena(popustDTO.getCena());
		
		KartaDTO kartaDTO = new KartaDTO();
		kartaDTO.setId(karta.getId());
		kartaDTO.setRed(karta.getRed());
		kartaDTO.setSediste(karta.getSediste());
		
		ProjekcijaDTO projekcijaDTO = new ProjekcijaDTO();
		projekcijaDTO.setId(projekcija.getId());
		projekcijaDTO.setCena(projekcija.getCena());
		projekcijaDTO.setNazivSale(projekcija.getSala().getNazivSale());
		projekcijaDTO.setVreme(projekcija.getVreme());
		projekcijaDTO.setDatum(projekcija.getDatum());
		projekcijaDTO.setNazivDela(projekcija.getDelo().getNaziv());
		
		kartaNaPopustuDTO.setKarta(kartaDTO);
		kartaNaPopustuDTO.setProjekcija(projekcijaDTO);
		
		return kartaNaPopustuDTO;
	}
	
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public void obrisiPopust(Long idPopusta) {
		KartaNaPopustu kartaNaPopustu = kartaNaPopustuRepository.findOne(idPopusta);
		Karta karta = kartaNaPopustu.getKarta();
		karta.setRezervisana(false);
		kartaRepository.save(karta);
		kartaNaPopustuRepository.delete(idPopusta);
	}
	
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public boolean brzoRezervisiKartu(Long popustId, Long korisnikId) {
		KartaNaPopustu popust = kartaNaPopustuRepository.findOne(popustId);
		Karta karta = popust.getKarta();
		if (popust.isRezervisana()) {
			return false;
		} else {
			popust.setRezervisana(true);
			karta.setKupac(korisnikRepository.findOne(korisnikId));
			kartaRepository.save(karta);
			kartaNaPopustuRepository.save(popust);
			return true;
		}
	}
	
	//endregion

		@Override
		@Transactional
		public void oceniProjekciju(RezervacijaDTO rezervacijaDTO) {
			Karta karta = kartaRepository.findOne(rezervacijaDTO.getKartaId());
			karta.setOcenaProjekcije(rezervacijaDTO.getOcenaProjekcije());

			kartaRepository.save(karta);
		}

		@Override
		@Transactional
		public void oceniAmbijent(RezervacijaDTO rezervacijaDTO) {
			Karta karta = kartaRepository.findOne(rezervacijaDTO.getKartaId());
			karta.setOcenaAmbijenta(rezervacijaDTO.getOcenaAmbijenta());

			kartaRepository.save(karta);
		}
}
