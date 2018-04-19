package isa.projekat.controller;


import isa.projekat.model.DTO.RekvizitDTO;
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

    @RequestMapping(method = RequestMethod.PUT,value = "/secured/izmeni")
    public ResponseEntity izmeniRekvizit(@RequestBody RekvizitDTO rekvizitDTO) {
        rekvizitService.izmeniRekvizit(rekvizitDTO);
        return ResponseEntity.ok(rekvizitDTO);
    }
}
