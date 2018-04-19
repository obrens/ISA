package isa.projekat.service;

import isa.projekat.model.DTO.DimenzijeSaleDTO;
import isa.projekat.model.DTO.ProjekcijaDTO;
import isa.projekat.model.Delo;
import isa.projekat.model.Projekcija;
import isa.projekat.model.Sala;
import isa.projekat.repository.DeloRepository;
import isa.projekat.repository.ProjekcijaRepository;
import isa.projekat.repository.UstanovaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjekcijaService {
	@Autowired
	UstanovaRepository ustanovaRepository;
	
	@Autowired
	DeloRepository deloRepository;
	
	@Autowired
	ProjekcijaRepository projekcijaRepository;
	
	public List<ProjekcijaDTO> projekcijeUstanove(Long id) {
		List<Delo> dela = deloRepository.findByUstanova(ustanovaRepository.findById(id));
		ArrayList<ProjekcijaDTO> projekcijaDTOs = new ArrayList<ProjekcijaDTO>();
		for (Delo delo : dela) {
			for (Projekcija projekcija : projekcijaRepository.findByDelo(delo)) {
				ProjekcijaDTO projekcijaDTO = new ProjekcijaDTO();
				projekcijaDTO.setId(projekcija.getId());
				projekcijaDTO.setNazivDela(delo.getNaziv());
				projekcijaDTO.setDatum(projekcija.getDatum());
				projekcijaDTO.setVreme(projekcija.getVreme());
				projekcijaDTO.setNazivSale(projekcija.getSala().getNazivSale());
				projekcijaDTO.setCena(projekcija.getCena());
				projekcijaDTOs.add(projekcijaDTO);
			}
		}
		
		return projekcijaDTOs;
	}
	
	public DimenzijeSaleDTO dimenzijeSale(Long idProjekcije) {
		Sala sala = projekcijaRepository.findOne(idProjekcije).getSala();
		DimenzijeSaleDTO dimenzijeSaleDTO = new DimenzijeSaleDTO();
		dimenzijeSaleDTO.setRedovi(sala.getBrojRedova());
		dimenzijeSaleDTO.setKolone(sala.getBrojKolona());
		return dimenzijeSaleDTO;
	}
}
