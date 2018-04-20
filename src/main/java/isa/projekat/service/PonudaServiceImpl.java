package isa.projekat.service;

import isa.projekat.model.DTO.PonudaDTO;
import isa.projekat.model.Ponuda;
import isa.projekat.repository.PonudaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PonudaServiceImpl implements PonudaService {
    @Autowired
    PonudaRepository ponudaRepository;

    @Override
	public Ponuda napraviPonudu(PonudaDTO ponudaDTO){
        Ponuda ponuda = new Ponuda();
        ponuda.setId(ponudaDTO.getId());
        ponuda.setCena(ponudaDTO.getCena());
        ponuda.setOglas(ponudaDTO.getOglas());
        ponuda.setPonudjac(ponudaDTO.getPonudjac());
        ponudaRepository.save(ponuda);
        return ponuda;
    }
}
