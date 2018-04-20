package isa.projekat.controller;

import isa.projekat.model.DTO.TipKorisnikaDTO;
import isa.projekat.repository.TipKorisnikaRepository;
import isa.projekat.service.TipKorisnikaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tip")
public class TipKorisnikaController {
    @Autowired
    TipKorisnikaRepository tipKorisnikaRepository;

    @Autowired
    TipKorisnikaService tipKorisnikaService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity getTip(@PathVariable Long id) {
        TipKorisnikaDTO tipKorisnikaDTO = tipKorisnikaService.tipZaSlanje(tipKorisnikaRepository.findById(id));
        if (tipKorisnikaDTO != null)
            return ResponseEntity.ok(tipKorisnikaDTO);
        else
            return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
