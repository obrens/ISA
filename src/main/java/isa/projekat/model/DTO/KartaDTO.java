package isa.projekat.model.DTO;

public class KartaDTO {
	private Long id;
	private int red;
	private int sediste;
	private boolean rezervisana;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
}
