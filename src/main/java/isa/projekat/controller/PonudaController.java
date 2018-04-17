package isa.projekat.controller;

import isa.projekat.repository.PonudaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ponuda")
public class PonudaController {
    @Autowired
    PonudaRepository ponudaRepository;


}
