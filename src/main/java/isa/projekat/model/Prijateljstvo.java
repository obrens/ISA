package isa.projekat.model;

import javax.persistence.*;

@Entity
public class Prijateljstvo {
	@Id
	@Column(name = "korisnik_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn
	Korisnik zahtevni;
	
	@ManyToOne
	@JoinColumn
	Korisnik prihvatni;
	
	@Column
	boolean prihvaceno;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Korisnik getZahtevni() {
		return zahtevni;
	}
	
	public void setZahtevni(Korisnik zahtevni) {
		this.zahtevni = zahtevni;
	}
	
	public Korisnik getPrihvatni() {
		return prihvatni;
	}
	
	public void setPrihvatni(Korisnik prihvatni) {
		this.prihvatni = prihvatni;
	}
	
	public boolean isPrihvaceno() {
		return prihvaceno;
	}
	
	public void setPrihvaceno(boolean prihvaceno) {
		this.prihvaceno = prihvaceno;
	}
}
