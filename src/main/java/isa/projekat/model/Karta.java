package isa.projekat.model;

import javax.persistence.*;

@Entity
public class Karta {
	@Id
	@Column(name = "karta_id")
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn
	private Projekcija projekcija;
	
	@Column
	private boolean rezervisana;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Projekcija getProjekcija() {
		return projekcija;
	}
	
	public void setProjekcija(Projekcija projekcija) {
		this.projekcija = projekcija;
	}
	
	public boolean isRezervisana() {
		return rezervisana;
	}
	
	public void setRezervisana(boolean rezervisana) {
		this.rezervisana = rezervisana;
	}
}
