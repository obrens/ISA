package isa.projekat.controller;

import isa.projekat.model.DTO.DimenzijeSaleDTO;
import isa.projekat.model.DTO.NovaProjekcijaDTO;
import isa.projekat.model.DTO.ProjekcijaDTO;
import isa.projekat.model.Projekcija;
import isa.projekat.service.ProjekcijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
	public ResponseEntity dimenzijeSale(@PathVariable Long idProjekcije) {
		DimenzijeSaleDTO dimenzijeSaleDTO = projekcijaService.dimenzijeSale(idProjekcije);
		return ResponseEntity.ok(dimenzijeSaleDTO);
	}
	
	@PreAuthorize("hasAnyRole('Administrator ustanove')")
	@RequestMapping(method = RequestMethod.POST, value = "/secured/dodaj")
	public ResponseEntity dodaj(@RequestBody NovaProjekcijaDTO novaProjekcijaDTO) {
		Projekcija projekcija = projekcijaService.napravi(novaProjekcijaDTO);
		if (projekcija != null) {
			return ResponseEntity.ok(projekcija);
		} else {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
