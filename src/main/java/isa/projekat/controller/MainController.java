package isa.projekat.controller;

import isa.projekat.model.Korisnik;
import isa.projekat.model.Ustanova;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

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
        String imejl = ((Korisnik)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getImejl();
        usaar.setNaziv(imejl);

        return usaar;
    }
}
