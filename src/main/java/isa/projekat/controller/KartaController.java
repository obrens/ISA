package isa.projekat.controller;

import isa.projekat.model.DTO.KartaDTO;
import isa.projekat.model.DTO.KartaNaPopustuDTO;
import isa.projekat.model.DTO.PopustDTO;
import isa.projekat.model.DTO.RezervacijaDTO;
import isa.projekat.model.Karta;
import isa.projekat.repository.KartaRepository;
import isa.projekat.service.KartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HttpsURLConnection;
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
	
	@RequestMapping(method = RequestMethod.GET, value = "/rezervacije/{korisnikId}")
	public ResponseEntity rezervacijeKorisnika(@PathVariable Long korisnikId){
		List<RezervacijaDTO> rezervacije = kartaService.rezervacijeKorisnika(korisnikId);
		return ResponseEntity.ok(rezervacije);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/posete/{korisnikId}")
	public ResponseEntity posete(@PathVariable Long korisnikId){
		List<RezervacijaDTO> posete = kartaService.poseteKorisnika(korisnikId);
		return ResponseEntity.ok(posete);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/otkazi/{id}")
	public ResponseEntity otkazi(@PathVariable Long id){
		kartaService.otkazi(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	//region Popusti
	
	@RequestMapping(method = RequestMethod.GET, value = "/popusti/{ustanovaId}")
	public ResponseEntity popusti(@PathVariable Long ustanovaId){
		List<KartaNaPopustuDTO> popusti = kartaService.popusti(ustanovaId);
		return ResponseEntity.ok(popusti);
	}
	
	/*@RequestMapping(method = RequestMethod.POST, value = "/dodajPopust")
	public ResponseEntity dodajPopust(@RequestBody PopustDTO popustDTO){
		KartaNaPopustuDTO kartaNaPopustuDTO = kartaService.dodajPopust(popustDTO);
		return ResponseEntity.ok(kartaNaPopustuDTO);
	}*/
	
	//@RequestMapping(method = RequestMethod.DELETE, value = "/obrisiPopust/{id}")
	//public ResponseEntity obrisiPopust(@PathVariable Long id)
	
	//endregion
	
}
