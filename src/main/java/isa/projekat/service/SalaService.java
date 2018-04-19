package isa.projekat.service;

import isa.projekat.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaService {
	@Autowired
	SalaRepository salaRepository;
}
