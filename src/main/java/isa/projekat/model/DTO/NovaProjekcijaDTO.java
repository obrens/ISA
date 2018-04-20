package isa.projekat.model.DTO;

import java.sql.Time;
import java.util.Date;

public class NovaProjekcijaDTO {
	private Long idDela;
	private Long idSale;
	private Date datum;
	//private Time vreme;
	private Float cena;
	
	public Long getIdDela() {
		return idDela;
	}
	
	public void setIdDela(Long idDela) {
		this.idDela = idDela;
	}
	
	public Long getIdSale() {
		return idSale;
	}
	
	public void setIdSale(Long idSale) {
		this.idSale = idSale;
	}
	
	public Date getDatum() {
		return datum;
	}
	
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
	/*public Time getVreme() {
		return vreme;
	}
	
	public void setVreme(Time vreme) {
		this.vreme = vreme;
	}*/
	
	public Float getCena() {
		return cena;
	}
	
	public void setCena(Float cena) {
		this.cena = cena;
	}
}
