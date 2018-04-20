package isa.projekat.controller;

import isa.projekat.model.Sala;
import isa.projekat.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sala")
public class SalaController {
	@Autowired
	SalaService salaService;
	
	@PreAuthorize("hasAnyRole('Administrator ustanove')")
	@RequestMapping(method = RequestMethod.GET, value = "/secured/saleUstanove/{idUstanove}")
	public ResponseEntity saleUstanove(@PathVariable Long idUstanove){
		List<Sala> sale = salaService.saleUstanove(idUstanove);
		return ResponseEntity.ok(sale);
	}
	
	@PreAuthorize("hasAnyRole('Administrator ustanove')")
	@RequestMapping(method = RequestMethod.PUT, value = "/secured/promeni")
	public ResponseEntity promeni(@RequestBody Sala sala){
		salaService.promeni(sala);
		return ResponseEntity.ok(sala);
	}
	
	@PreAuthorize("hasAnyRole('Administrator ustanove')")
	@RequestMapping(method = RequestMethod.POST, value = "/secured/dodaj/{idUstanove}")
	public ResponseEntity dodaj(@PathVariable Long idUstanove, @RequestBody Sala sala){
		salaService.dodaj(sala, idUstanove);
		return ResponseEntity.ok(sala);
	}
}
