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
	private int red;
	
	@Column
	private int sediste;
	
	@Column
	private boolean rezervisana;
	
	@ManyToOne
	@JoinColumn
	private Korisnik kupac;
	
	@Column
	private boolean ocenjenaProjekcija;
	
	@Column
	private int ocenaProjekcije;
	
	@Column
	private boolean ocenjenAmbijent;
	
	@Column
	private int ocenaAmbijenta;
	
	public boolean isOcenjenaProjekcija() {
		return ocenjenaProjekcija;
	}
	
	public void setOcenjenaProjekcija(boolean ocenjenaProjekcija) {
		this.ocenjenaProjekcija = ocenjenaProjekcija;
	}
	
	public int getOcenaProjekcije() {
		return ocenaProjekcije;
	}
	
	public void setOcenaProjekcije(int ocenaProjekcije) {
		this.ocenaProjekcije = ocenaProjekcije;
	}
	
	public boolean isOcenjenAmbijent() {
		return ocenjenAmbijent;
	}
	
	public void setOcenjenAmbijent(boolean ocenjenAmbijent) {
		this.ocenjenAmbijent = ocenjenAmbijent;
	}
	
	public int getOcenaAmbijenta() {
		return ocenaAmbijenta;
	}
	
	public void setOcenaAmbijenta(int ocenaAmbijenta) {
		this.ocenaAmbijenta = ocenaAmbijenta;
	}
	
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
	
	public int getRed() {
		return red;
	}
	
	public void setRed(int red) {
		this.red = red;
	}
	
	public int getSediste() {
		return sediste;
	}
	
	public void setSediste(int sediste) {
		this.sediste = sediste;
	}
	
	public boolean isRezervisana() {
		return rezervisana;
	}
	
	public void setRezervisana(boolean rezervisana) {
		this.rezervisana = rezervisana;
	}
	
	public Korisnik getKupac() {
		return kupac;
	}
	
	public void setKupac(Korisnik kupac) {
		this.kupac = kupac;
	}
}
