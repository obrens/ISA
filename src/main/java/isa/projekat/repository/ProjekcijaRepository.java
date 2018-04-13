package isa.projekat.repository;

import isa.projekat.model.Delo;
import isa.projekat.model.Projekcija;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjekcijaRepository extends JpaRepository<Projekcija, Long> {
	Projekcija findById(Long id);
	
	List<Projekcija> findByDelo(Delo delo);
}
