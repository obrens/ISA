package isa.projekat.controller;

import isa.projekat.model.DTO.KorisnikDTO;
import isa.projekat.model.DTO.PrijateljDTO;
import isa.projekat.model.DTO.UstanovaDTO;
import isa.projekat.model.Korisnik;
import isa.projekat.repository.KorisnikRepository;
import isa.projekat.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/korisnik")
public class KorisnikController {
	@Autowired
	KorisnikService korisnikService;

	@Autowired
	KorisnikRepository korisnikRepository;
	
	@RequestMapping(method = RequestMethod.POST, value = "/secured/registruj")
	public ResponseEntity registruj(@RequestBody KorisnikDTO korisnikDTO){
		Korisnik korisnik = korisnikService.napraviKorisnika(korisnikDTO);
		return ResponseEntity.ok(korisnik);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity getKorisnika(@PathVariable Long id){
		KorisnikDTO korisnikDTO = korisnikService.korisnikDTO(korisnikRepository.findById(id));
		if (korisnikDTO != null)
			return ResponseEntity.ok(korisnikDTO);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/secured/svi")
	public ResponseEntity getPrijateljiINeprijatelji() {
		Korisnik korisnik = (Korisnik) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<PrijateljDTO> prijatelji = korisnikService.prijateljiINeprijatelji(korisnik);
		return ResponseEntity.ok(prijatelji);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/secured/ja")
	public ResponseEntity getJa() {
		Korisnik korisnik = (Korisnik) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return ResponseEntity.ok(korisnik);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/secured/zahtevni")
	public ResponseEntity getZahtevni() {
		Korisnik korisnik = (Korisnik) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<PrijateljDTO> zahtevni = korisnikService.zahtevni(korisnik);
		return ResponseEntity.ok(zahtevni);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/secured/zahtevamPrijatelja/{prijateljId}")
	public ResponseEntity zahtevamPrijatelja(@PathVariable Long prijateljId){
		Korisnik korisnik = (Korisnik) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Korisnik prijatelj = korisnikService.zahtevamPrijatelja(korisnik.getId(), prijateljId);
		return ResponseEntity.ok(prijatelj);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/secured/prihvatamPrijatelja/{prijateljstvoId}")
	public ResponseEntity prihvatamPrijatelja(@PathVariable Long prijateljstvoId){
		Korisnik korisnik = korisnikService.prihvatamTePrijateljuOberucke(prijateljstvoId);
		return ResponseEntity.ok(korisnik);
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/secured/gubimPrijatelja/{prijateljstvoId}")
	public ResponseEntity gubimPrijatelja(@PathVariable Long prijateljstvoId){
		korisnikService.gubimPrijatelja(prijateljstvoId);
		return new ResponseEntity(HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/secured/izmeni")
	public ResponseEntity izmeniKorisnika(@RequestBody KorisnikDTO korisnikDTO){
		korisnikService.izmeniKorisnika(korisnikDTO);
		return ResponseEntity.ok(korisnikDTO);
	}
}
