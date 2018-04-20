package isa.projekat.model.DTO;

public class PrijateljDTO {
	private Long id;
	private String ime;
	private String prezime;
	private boolean prijatelj;
	private Long prijateljstvoId;
	private String imejl;

	public String getImejl() {return imejl;}

	public void setImejl(String imejl) {this.imejl = imejl;	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public boolean isPrijatelj() {
		return prijatelj;
	}
	
	public void setPrijatelj(boolean prijatelj) {
		this.prijatelj = prijatelj;
	}
	
	public Long getPrijateljstvoId() {
		return prijateljstvoId;
	}
	
	public void setPrijateljstvoId(Long prijateljstvoId) {
		this.prijateljstvoId = prijateljstvoId;
	}
}
