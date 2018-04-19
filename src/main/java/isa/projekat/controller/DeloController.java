package isa.projekat.controller;

import isa.projekat.model.Delo;
import isa.projekat.service.DeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/delo")
public class DeloController {
	@Autowired
	DeloService deloService;
	
	@PreAuthorize("hasAnyRole('Administrator ustanove')")
	@RequestMapping(method = RequestMethod.GET, value = "/secured/delaUstanove/{idUstanove}")
	public ResponseEntity delaUstanove(@PathVariable Long idUstanove){
		List<Delo> dela = deloService.delaUstanove(idUstanove);
		return ResponseEntity.ok(dela);
	}
}
