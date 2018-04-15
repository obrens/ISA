package isa.projekat.controller;


import isa.projekat.repository.RekvizitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rekvizit")
public class RekvizitController {
    @Autowired
    RekvizitRepository rekvizitRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/svi")
    public ResponseEntity getSveRekvizite() {
        return new ResponseEntity<>(rekvizitRepository.findAll(), HttpStatus.OK);
    }
}
