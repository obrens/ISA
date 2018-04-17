package isa.projekat.controller;

import isa.projekat.model.Ustanova;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String hello() {
        System.out.println("helou");
        return "Hello";
    }
    @PreAuthorize("hasAnyRole('Administrator sistema')")
    @RequestMapping(method = RequestMethod.GET, value = "/secured/usa")
    public Ustanova usa() {
        Ustanova usaar = new Ustanova();
        usaar.setNaziv("obika");

        return usaar;
    }
}
