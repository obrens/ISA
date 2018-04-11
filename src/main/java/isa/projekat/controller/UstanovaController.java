package isa.projekat.controller;

import isa.projekat.model.DTO.UstanovaDTO;
import isa.projekat.model.Ustanova;
import isa.projekat.repository.UstanovaRepository;
import isa.projekat.service.UstanovaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ustanova")
public class UstanovaController {
	@Autowired
	UstanovaRepository ustanovaRepository;
	
	@Autowired
	UstanovaService ustanovaService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/sve")
	public ResponseEntity getSveUstanove() {
		return new ResponseEntity<>(ustanovaRepository.findAll(), HttpStatus.OK); 	// Ovo je valjda...
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity getUstanova(@PathVariable Long id) {
		return ResponseEntity.ok(ustanovaRepository.findById(id));
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/dodaj")
	public ResponseEntity dodajUstanovu(@RequestBody UstanovaDTO ustanovaDTO) {
		Ustanova ustanova = ustanovaService.napraviUstanovu(ustanovaDTO);
		if (ustanova!=null){
			return ResponseEntity.ok(ustanova);										// ...isto kao i ovo
		}else{
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}