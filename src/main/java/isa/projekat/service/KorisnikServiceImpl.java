package isa.projekat.service;

import isa.projekat.model.DTO.KorisnikDTO;
import isa.projekat.model.DTO.PrijateljDTO;
import isa.projekat.model.Korisnik;
import isa.projekat.model.Prijateljstvo;
import isa.projekat.repository.KorisnikRepository;
import isa.projekat.repository.PrijateljstvoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class KorisnikServiceImpl implements KorisnikService {
	@Autowired
	KorisnikRepository korisnikRepository;
	
	@Autowired
	PrijateljstvoRepository prijateljstvoRepository;


	@Override
	public KorisnikDTO korisnikDTO(Korisnik korisnik){
		KorisnikDTO korisnikDTO= new KorisnikDTO();
		korisnikDTO.setId(korisnik.getId());
		korisnikDTO.setIme(korisnik.getIme());
		korisnikDTO.setBrojTelefona(korisnik.getBrojTelefona());
		korisnikDTO.setPrezime(korisnik.getPrezime());
		korisnikDTO.setLozinka(korisnik.getLozinka());
		korisnikDTO.setGrad(korisnik.getGrad());
		korisnikDTO.setImejl(korisnik.getImejl());
		korisnikDTO.setUloge(korisnik.getUloge());
		return korisnikDTO;
	}

	@Override
	public List<PrijateljDTO> prijateljiINeprijatelji(Korisnik korisnik) {
		List<PrijateljDTO> prijateljDTOs = new ArrayList<>();
		List<Long> ids = new ArrayList<>();
		
		List<Prijateljstvo> prijatelji = prijateljstvoRepository.findByPrihvatni(korisnik);
		for (Prijateljstvo prijateljstvo : prijatelji) {
			PrijateljDTO prijateljDTO = new PrijateljDTO();
			Korisnik prijatelj = prijateljstvo.getZahtevni();
			if(!prijateljstvo.isPrihvaceno()){
				ids.add(prijatelj.getId());
				continue;
			}
			prijateljDTO.setId(prijatelj.getId());
			prijateljDTO.setIme(prijatelj.getIme());
			prijateljDTO.setPrezime(prijatelj.getPrezime());
			prijateljDTO.setPrijateljstvoId(prijateljstvo.getId());
			prijateljDTO.setPrijatelj(true);
			prijateljDTOs.add(prijateljDTO);
			ids.add(prijatelj.getId());
		}
		
		prijatelji = prijateljstvoRepository.findByZahtevni(korisnik);
		for (Prijateljstvo prijateljstvo : prijatelji) {
			PrijateljDTO prijateljDTO = new PrijateljDTO();
			Korisnik prijatelj = prijateljstvo.getPrihvatni();
			if(!prijateljstvo.isPrihvaceno()){
				ids.add(prijatelj.getId());
				continue;
			}
			prijateljDTO.setId(prijatelj.getId());
			prijateljDTO.setIme(prijatelj.getIme());
			prijateljDTO.setPrezime(prijatelj.getPrezime());
            prijateljDTO.setPrijateljstvoId(prijateljstvo.getId());
			prijateljDTO.setPrijatelj(true);
			prijateljDTOs.add(prijateljDTO);
			ids.add(prijatelj.getId());
		}
		
		List<Korisnik> korisnici = korisnikRepository.findAll();
		for (Korisnik k : korisnici){
			if (ids.contains(k.getId())) continue;
			PrijateljDTO neprijateljDTO = new PrijateljDTO();
			neprijateljDTO.setId(k.getId());
			neprijateljDTO.setIme(k.getIme());
			neprijateljDTO.setPrezime(k.getPrezime());
			neprijateljDTO.setPrijatelj(false);
			prijateljDTOs.add(neprijateljDTO);
		}
		
		return prijateljDTOs;
	}
	
	@Override
	public List<PrijateljDTO> zahtevni(Korisnik korisnik) {
		List<PrijateljDTO> zahtevni = new ArrayList<>();
		
		List<Prijateljstvo> prijateljstva = prijateljstvoRepository.findByPrihvatni(korisnik);
		for (Prijateljstvo prijateljstvo : prijateljstva){
			if(!prijateljstvo.isPrihvaceno()){
				PrijateljDTO prijateljDTO = new PrijateljDTO();
				Korisnik zahtevan = prijateljstvo.getZahtevni();
				prijateljDTO.setId(zahtevan.getId());
				prijateljDTO.setIme(zahtevan.getIme());
				prijateljDTO.setPrezime(zahtevan.getPrezime());
				prijateljDTO.setPrijateljstvoId(prijateljstvo.getId());
				zahtevni.add(prijateljDTO);
			}
		}
		
		return zahtevni;
	}
	
	@Override
	public Korisnik napraviKorisnika(KorisnikDTO korisnikDTO) {
		Korisnik korisnik = new Korisnik();
		korisnik.setImejl(korisnikDTO.getImejl());
		korisnik.setIme(korisnikDTO.getIme());
		korisnik.setPrezime(korisnikDTO.getPrezime());
		korisnik.setLozinka(korisnikDTO.getLozinka());
		korisnik.setGrad(korisnikDTO.getGrad());
		korisnik.setBrojTelefona(korisnikDTO.getBrojTelefona());
		korisnikRepository.save(korisnik);
		return korisnik;
	}
	
	@Override
	public Korisnik zahtevamPrijatelja(Long id, Long idPrijatelja) {
		Korisnik korisnik = korisnikRepository.findOne(id);
		Korisnik prijatelj = korisnikRepository.findOne(idPrijatelja);
		Prijateljstvo prijateljstvo = new Prijateljstvo();
		prijateljstvo.setZahtevni(korisnik);
		prijateljstvo.setPrihvatni(prijatelj);
		prijateljstvo.setPrihvaceno(false);
		prijateljstvoRepository.save(prijateljstvo);
		return prijatelj;
	}

	@Override
	@Transactional
	public void izmeniKorisnika(KorisnikDTO korisnikDTO){
		Korisnik korisnik = korisnikRepository.findOne(korisnikDTO.getId());
		korisnik.setId(korisnikDTO.getId());
		korisnik.setBrojTelefona(korisnikDTO.getBrojTelefona());
		korisnik.setIme(korisnikDTO.getIme());
		korisnik.setPrezime(korisnikDTO.getPrezime());
		korisnik.setGrad(korisnikDTO.getGrad());
		korisnik.setImejl(korisnikDTO.getImejl());
		korisnik.setLozinka(korisnikDTO.getLozinka());
		korisnik.setUloge(korisnikDTO.getUloge());
		korisnikRepository.save(korisnik);
	}
	@Override
	@Transactional
	public void gubimPrijatelja(Long idPrijateljstva) {
		Prijateljstvo prijateljstvo = prijateljstvoRepository.findOne(idPrijateljstva);
		prijateljstvoRepository.delete(prijateljstvo);
	}

	@Override
	@Transactional
	public Korisnik prihvatamTePrijateljuOberucke(Long prijateljstvoId) {
		Prijateljstvo prijateljstvo = prijateljstvoRepository.findOne(prijateljstvoId);
		prijateljstvo.setPrihvaceno(true);
		Korisnik prijateljMojNovi = prijateljstvo.getZahtevni();
		prijateljstvoRepository.save(prijateljstvo);
		return prijateljMojNovi;
	}
}
