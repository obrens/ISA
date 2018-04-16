package isa.projekat.model.DTO;

import java.sql.Time;
import java.util.Date;

public class RezervacijaDTO {
	private Long kartaId;
	private String nazivDela;
	private Long projekcijaId;
	private Date datum;
	private Time vreme;
	private Long ustanovaId;
	private String nazivUstanove;
	private String nazivSale;
	private int red;
	private int sediste;
	private boolean ocenjenaProjekcija;
	private int ocenaProjekcije;
	private boolean ocenjenAmbijent;
	private int ocenaAmbijenta;
	
	public Long getKartaId() {
		return kartaId;
	}
	
	public void setKartaId(Long kartaId) {
		this.kartaId = kartaId;
	}
	
	public String getNazivDela() {
		return nazivDela;
	}
	
	public void setNazivDela(String nazivDela) {
		this.nazivDela = nazivDela;
	}
	
	public Long getProjekcijaId() {
		return projekcijaId;
	}
	
	public void setProjekcijaId(Long projekcijaId) {
		this.projekcijaId = projekcijaId;
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
	
	public Long getUstanovaId() {
		return ustanovaId;
	}
	
	public void setUstanovaId(Long ustanovaId) {
		this.ustanovaId = ustanovaId;
	}
	
	public String getNazivUstanove() {
		return nazivUstanove;
	}
	
	public void setNazivUstanove(String nazivUstanove) {
		this.nazivUstanove = nazivUstanove;
	}
	
	public String getNazivSale() {
		return nazivSale;
	}
	
	public void setNazivSale(String nazivSale) {
		this.nazivSale = nazivSale;
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
}
