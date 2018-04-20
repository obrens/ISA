package isa.projekat.service;

import isa.projekat.model.DTO.UstanovaDTO;
import isa.projekat.model.Ustanova;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UstanovaService {
	Ustanova napraviUstanovu(UstanovaDTO ustanovaDTO);

	UstanovaDTO ustanovaZaSlanje(Ustanova ustanova);

	@Transactional
	void izmeniUstanovu(UstanovaDTO ustanovaDTO);

	List<Ustanova> bioskopi();

	List<Ustanova> pozorista();

	List<Ustanova> svi();
}
