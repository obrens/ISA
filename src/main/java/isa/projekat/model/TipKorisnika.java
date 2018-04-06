package isa.projekat.model;

import javax.persistence.*;

@Entity
public class TipKorisnika {
	@Id
	@Column(name = "tipkorisnika_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String naziv;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
}
