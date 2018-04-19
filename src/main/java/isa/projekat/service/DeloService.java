package isa.projekat.service;

import isa.projekat.repository.DeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeloService {
	@Autowired
	DeloRepository deloRepository;
}
