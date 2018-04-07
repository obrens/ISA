package isa.projekat.repository;

import isa.projekat.model.Ustanova;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UstanovaRepository extends JpaRepository<Ustanova, Long> {
	Ustanova findById(Long id);
}
