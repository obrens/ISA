package isa.projekat.controller;

import isa.projekat.model.DTO.KartaDTO;
import isa.projekat.model.DTO.KartaNaPopustuDTO;
import isa.projekat.model.DTO.PopustDTO;
import isa.projekat.model.DTO.RezervacijaDTO;
import isa.projekat.model.Korisnik;
import isa.projekat.service.KartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/karta")
public class KartaController {
	@Autowired
	KartaService kartaService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/karteZaProjekciju/{id}")
	public ResponseEntity getKarteZaProjekciju(@PathVariable Long id) {
		List<KartaDTO> karteDTO = kartaService.karteZaProjekciju(id);
		return ResponseEntity.ok(karteDTO);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/rezervisi/{kartaId}")
	public ResponseEntity rezervisiKartu(@PathVariable("kartaId") Long kartaId) {
		Long korisnikId = ((Korisnik) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
		if (kartaService.rezervisiKartu(kartaId, korisnikId)) {
			return new ResponseEntity(HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/rezervacije")
	public ResponseEntity rezervacijeKorisnika() {
		Long korisnikId = ((Korisnik) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
		List<RezervacijaDTO> rezervacije = kartaService.rezervacijeKorisnika(korisnikId);
		return ResponseEntity.ok(rezervacije);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/posete")
	public ResponseEntity posete() {
		Long korisnikId = ((Korisnik) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
		List<RezervacijaDTO> posete = kartaService.poseteKorisnika(korisnikId);
		return ResponseEntity.ok(posete);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/otkazi/{id}")
	public ResponseEntity otkazi(@PathVariable Long id) {
		kartaService.otkazi(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	//region Popusti
	
	@RequestMapping(method = RequestMethod.GET, value = "/secured/dostupniPopusti/{ustanovaId}")
	public ResponseEntity dostupniPopusti(@PathVariable Long ustanovaId) {
		List<KartaNaPopustuDTO> popusti = kartaService.dostupniPopusti(ustanovaId);
		return ResponseEntity.ok(popusti);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/dodajPopust")
	public ResponseEntity dodajPopust(@RequestBody PopustDTO popustDTO) {
		KartaNaPopustuDTO kartaNaPopustuDTO = kartaService.dodajPopust(popustDTO);
		return ResponseEntity.ok(kartaNaPopustuDTO);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/secured/obrisiPopust/{idPopusta}")
	public ResponseEntity obrisiPopust(@PathVariable Long idPopusta) {
		kartaService.obrisiPopust(idPopusta);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/secured/brzoRezervisi/{popustId}")
	public ResponseEntity brzoRezervisiKartu(@PathVariable("popustId") Long popustId) {
		Long korisnikId = ((Korisnik) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
		if (kartaService.brzoRezervisiKartu(popustId, korisnikId)) {
			return new ResponseEntity(HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
	}
	
	//endregion
	
	@PreAuthorize("hasAnyRole('Registrovani korisnik')")
	@RequestMapping(method = RequestMethod.PUT, value = "/secured/oceniProjekciju")
	public ResponseEntity oceniProjekciju(@RequestBody RezervacijaDTO rezervacijaDTO) {
		kartaService.oceniProjekciju(rezervacijaDTO);
		return ResponseEntity.ok(rezervacijaDTO);
	}
	
	@PreAuthorize("hasAnyRole('Registrovani korisnik')")
	@RequestMapping(method = RequestMethod.PUT, value = "/secured/oceniAmbijent")
	public ResponseEntity oceniAmbijent(@RequestBody RezervacijaDTO rezervacijaDTO) {
		kartaService.oceniAmbijent(rezervacijaDTO);
		return ResponseEntity.ok(rezervacijaDTO);
	}
}
