package isa.projekat.controller;

import isa.projekat.model.DTO.PonudaDTO;
import isa.projekat.model.DTO.RekvizitDTO;
import isa.projekat.model.Ponuda;
import isa.projekat.model.Rekvizit;
import isa.projekat.repository.PonudaRepository;
import isa.projekat.repository.RekvizitRepository;
import isa.projekat.service.PonudaService;
import isa.projekat.service.RekvizitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ponuda")
public class PonudaController {
    @Autowired
    PonudaRepository ponudaRepository;

    @Autowired
    PonudaService ponudaService;

    @Autowired
    RekvizitRepository rekvizitRepository;

    @Autowired
    RekvizitService rekvizitService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity getPonudeOglasa(@PathVariable Long id) {
        RekvizitDTO rekvizitDTO = rekvizitService.rekvizitZaSlanje(rekvizitRepository.findById(id));
        return new ResponseEntity<>(ponudaRepository.findByOglas(rekvizitService.rekvizitZaPrimanje(rekvizitDTO)),HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/dodaj")
    public ResponseEntity dodajPonudu(@RequestBody PonudaDTO ponudaDTO) {
        Ponuda ponuda = ponudaService.napraviPonudu(ponudaDTO);
        if (ponuda != null) {
            return ResponseEntity.ok(ponuda);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
