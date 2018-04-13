package isa.projekat.model.DTO;

import java.sql.Time;
import java.util.Date;

public class ProjekcijaDTO {
	private Long id;
	private String nazivDela;
	private Date datum;
	private Time vreme;
	private String nazivSale;
	private float cena;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNazivDela() {
		return nazivDela;
	}
	
	public void setNazivDela(String nazivDela) {
		this.nazivDela = nazivDela;
	}
	
	public Date getDatum() {
		return datum;
	}
	
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
	public Time getVreme() {
		return vreme;
	}
	
	public void setVreme(Time vreme) {
		this.vreme = vreme;
	}
	
	public String getNazivSale() {
		return nazivSale;
	}
	
	public void setNazivSale(String nazivSale) {
		this.nazivSale = nazivSale;
	}
	
	public float getCena() {
		return cena;
	}
	
	public void setCena(float cena) {
		this.cena = cena;
	}
}
