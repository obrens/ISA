package isa.projekat.repository;

import isa.projekat.model.Korisnik;
import isa.projekat.model.Ustanova;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UstanovaRepository extends JpaRepository<Ustanova, Long> {
	Ustanova findById(Long id);
	
	List<Ustanova> findByAdmin(Korisnik admin);
	/*@Modifying
	@Query("UPDATE Ustanova u SET u.naziv = :naziv, u.opis = :opis, u.adresa = :adresa WHERE u.id = :id")
	int updateUstanova(@Param("id") Long id, @Param("naziv") String naziv, @Param("opis") String opis, @Param("adresa") String adresa);
	*/
}
