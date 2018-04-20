package isa.projekat.controller;

import isa.projekat.model.DTO.UstanovaDTO;
import isa.projekat.model.Korisnik;
import isa.projekat.model.Ustanova;
import isa.projekat.repository.UstanovaRepository;
import isa.projekat.service.UstanovaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ustanova")
public class UstanovaController {
	@Autowired
	UstanovaRepository ustanovaRepository;
	
	@Autowired
	UstanovaService ustanovaService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/secured/bioskopi")
	public ResponseEntity getSveBioskope() {
		return new ResponseEntity<>(ustanovaService.bioskopi(), HttpStatus.OK);    // Ovo je valjda...
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/secured/pozorista")
	public ResponseEntity getSvePozoriste() {
		return new ResponseEntity<>(ustanovaService.pozorista(), HttpStatus.OK);    // Ovo je valjda...
	}
	
	@PreAuthorize("hasAnyRole('Administrator ustanove')")
	@RequestMapping(method = RequestMethod.GET, value = "/secured/moja")
	public ResponseEntity getUstanova() {
		Korisnik admin = (Korisnik) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Ustanova> ustanoveAdmina = ustanovaRepository.findByAdmin(admin);
		UstanovaDTO ustanovaDTO = ustanovaService.ustanovaZaSlanje(ustanoveAdmina.get(0));
		if (ustanovaDTO != null)
			return ResponseEntity.ok(ustanovaDTO);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/dodaj")
	public ResponseEntity dodajUstanovu(@RequestBody UstanovaDTO ustanovaDTO) {
		Ustanova ustanova = ustanovaService.napraviUstanovu(ustanovaDTO);
		if (ustanova != null) {
			return ResponseEntity.ok(ustanova);                                        // ...isto kao i ovo
		} else {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/secured/izmeni")
	public ResponseEntity izmeniUstanovu(@RequestBody UstanovaDTO ustanovaDTO) {
		//Long id =
		ustanovaService.izmeniUstanovu(ustanovaDTO);
		return ResponseEntity.ok(ustanovaDTO);
	}
}
