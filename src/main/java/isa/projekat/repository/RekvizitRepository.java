package isa.projekat.repository;

import isa.projekat.model.Rekvizit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RekvizitRepository extends JpaRepository<Rekvizit,Long>{
    Rekvizit findById(Long id);
}
