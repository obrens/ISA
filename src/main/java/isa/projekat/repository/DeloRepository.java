package isa.projekat.repository;

import isa.projekat.model.Delo;
import isa.projekat.model.Ustanova;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeloRepository extends JpaRepository<Delo, Long> {
	Delo findById(Long id);
	
	List<Delo> findByUstanova(Ustanova ustanova);
}
