package isa.projekat.controller;


import isa.projekat.model.DTO.RekvizitDTO;
import isa.projekat.model.Rekvizit;
import isa.projekat.repository.RekvizitRepository;
import isa.projekat.service.RekvizitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rekvizit")
public class RekvizitController {
    @Autowired
    RekvizitRepository rekvizitRepository;

    @Autowired
    RekvizitService rekvizitService;

    @RequestMapping(method = RequestMethod.GET, value = "/svi")
    public ResponseEntity getSveRekvizite() {
        return new ResponseEntity<>(rekvizitRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity getRekvizit(@PathVariable Long id) {
        RekvizitDTO rekvizitDTO = rekvizitService.rekvizitZaSlanje(rekvizitRepository.findById(id));
        if (rekvizitDTO != null)
            return ResponseEntity.ok(rekvizitDTO);
        else
            return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/secured/izmeni")
    public ResponseEntity izmeniRekvizit(@RequestBody RekvizitDTO rekvizitDTO) {
        rekvizitService.izmeniRekvizit(rekvizitDTO);
        return ResponseEntity.ok(rekvizitDTO);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/dodaj")
    public ResponseEntity dodajRekvizit(@RequestBody RekvizitDTO rekvizitDTO) {
        Rekvizit rekvizit = rekvizitService.napraviRekvizit(rekvizitDTO);
        if (rekvizit != null) {
            return ResponseEntity.ok(rekvizit);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/izbrisi/{id}")
    public  ResponseEntity izbrisiRekvizit(@PathVariable Long id){
        Rekvizit rekvizit = rekvizitRepository.findById(id);
        if (rekvizit != null) {
            rekvizitService.izbrisiRekvizit(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
