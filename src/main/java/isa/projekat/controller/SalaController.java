package isa.projekat.controller;

import isa.projekat.model.Sala;
import isa.projekat.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
