package isa.projekat.controller;

import isa.projekat.model.DTO.PonudaDTO;
import isa.projekat.model.DTO.RekvizitDTO;
import isa.projekat.model.Rekvizit;
import isa.projekat.repository.PonudaRepository;
import isa.projekat.repository.RekvizitRepository;
import isa.projekat.service.RekvizitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ponuda")
public class PonudaController {
    @Autowired
    PonudaRepository ponudaRepository;

    @Autowired
    RekvizitRepository rekvizitRepository;

    @Autowired
    RekvizitService rekvizitService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity getPonudeOglasa(@PathVariable Long id) {
        RekvizitDTO rekvizitDTO = rekvizitService.rekvizitZaSlanje(rekvizitRepository.findById(id));
        return new ResponseEntity<>(ponudaRepository.findByOglas(rekvizitService.rekvizitZaPrimanje(rekvizitDTO)),HttpStatus.OK);
    }

}
