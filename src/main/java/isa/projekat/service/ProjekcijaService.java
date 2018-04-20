package isa.projekat.service;

import isa.projekat.model.DTO.DimenzijeSaleDTO;
import isa.projekat.model.DTO.NovaProjekcijaDTO;
import isa.projekat.model.DTO.ProjekcijaDTO;
import isa.projekat.model.Projekcija;

import java.util.List;

public interface ProjekcijaService {
	List<ProjekcijaDTO> projekcijeUstanove(Long id);
	
	DimenzijeSaleDTO dimenzijeSale(Long idProjekcije);
	
	Projekcija napravi(NovaProjekcijaDTO novaProjekcijaDTO);
}
