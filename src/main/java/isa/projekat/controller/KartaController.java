package isa.projekat.controller;

import isa.projekat.model.DTO.KartaDTO;
import isa.projekat.service.KartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
	@RequestMapping(method = RequestMethod.POST, value = "/rezervisi/{kartaId}/{korisnikId}")
	public ResponseEntity rezervisiKartu(@PathVariable("kartaId") Long kartaId, @PathVariable("korisnikId") Long korisnikId) {
		if (kartaService.rezervisiKartu(kartaId, korisnikId)) {
			return new ResponseEntity(HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
	}
}
