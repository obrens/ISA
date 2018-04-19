package isa.projekat.service;

import isa.projekat.model.DTO.DimenzijeSaleDTO;
import isa.projekat.model.DTO.NovaProjekcijaDTO;
import isa.projekat.model.DTO.ProjekcijaDTO;
import isa.projekat.model.Delo;
import isa.projekat.model.Karta;
import isa.projekat.model.Projekcija;
import isa.projekat.model.Sala;
import isa.projekat.repository.*;
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
	SalaRepository salaRepository;
	
	@Autowired
	KartaRepository kartaRepository;
	
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
	
	public Projekcija napravi(NovaProjekcijaDTO novaProjekcijaDTO) {
		Projekcija projekcija = new Projekcija();
		Delo delo = deloRepository.findOne(novaProjekcijaDTO.getIdDela());
		projekcija.setDelo(delo);
		projekcija.setSala(salaRepository.findOne(novaProjekcijaDTO.getIdSale()));
		projekcija.setDatum(novaProjekcijaDTO.getDatum());
		projekcija.setVreme(novaProjekcijaDTO.getVreme());
		Float cena = novaProjekcijaDTO.getCena();
		if (cena == null || cena == 0) {
			projekcija.setCena(delo.getCena());
		} else {
			projekcija.setCena(novaProjekcijaDTO.getCena());
		}
		
		projekcijaRepository.save(projekcija);
		izdodajiKarte(projekcija);
		return projekcija;
	}
	
	private void izdodajiKarte(Projekcija projekcija) {
		Sala sala = projekcija.getSala();
		for (int i = 1; i <= sala.getBrojRedova(); i++) {
			for (int j = 1; j <= sala.getBrojKolona(); j++) {
				Karta karta = new Karta();
				karta.setProjekcija(projekcija);
				karta.setRed(i);
				karta.setSediste(j);
				karta.setOcenjenAmbijent(false);
				karta.setOcenaAmbijenta(0);
				karta.setOcenjenaProjekcija(false);
				karta.setOcenaProjekcije(0);
				karta.setRezervisana(false);
				karta.setKupac(null);
				
				kartaRepository.save(karta);
			}
		}
	}
}
