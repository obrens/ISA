package isa.projekat.controller;

import isa.projekat.model.DTO.DimenzijeSaleDTO;
import isa.projekat.model.DTO.ProjekcijaDTO;
import isa.projekat.service.ProjekcijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/projekcija")
public class ProjekcijaController {
	@Autowired
	ProjekcijaService projekcijaService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/secured/projekcijeUstanove/{id}")
	public ResponseEntity getProjekcijeUstanove(@PathVariable Long id) {
		List<ProjekcijaDTO> projekcijaDTOs = projekcijaService.projekcijeUstanove(id);
		return ResponseEntity.ok(projekcijaDTOs);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/secured/dimenzijeSale/{idProjekcije}")
	public ResponseEntity dimenzijeSale(@PathVariable Long idProjekcije){
		DimenzijeSaleDTO dimenzijeSaleDTO = projekcijaService.dimenzijeSale(idProjekcije);
		return ResponseEntity.ok(dimenzijeSaleDTO);
	}
}
