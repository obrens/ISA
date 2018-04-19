package isa.projekat.repository;

import isa.projekat.model.Sala;
import isa.projekat.model.Ustanova;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaRepository extends JpaRepository<Sala, Long> {
	List<Sala> findByUstanova(Ustanova ustanova);
}
