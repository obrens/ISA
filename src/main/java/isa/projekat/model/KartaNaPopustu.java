package isa.projekat.model;

import javax.persistence.*;

@Entity
public class KartaNaPopustu {
	@Id
	@Column(name = "karta_na_popustu_id")
	@GeneratedValue
	private Long id;
	
	@OneToOne
	@JoinColumn
	private Karta karta;
	
	@Column
	private float cena;
	
	@Column
	private boolean rezervisana;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Karta getKarta() {
		return karta;
	}
	
	public void setKarta(Karta karta) {
		this.karta = karta;
	}
	
	public float getCena() {
		return cena;
	}
	
	public void setCena(float cena) {
		this.cena = cena;
	}
	
	public boolean isRezervisana() {
		return rezervisana;
	}
	
	public void setRezervisana(boolean rezervisana) {
		this.rezervisana = rezervisana;
	}
}
