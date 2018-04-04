package isa.projekat.model;

import javax.persistence.*;
import javax.sql.rowset.serial.SerialBlob;
import java.util.Date;
import java.util.ArrayList;

@Entity
public class Delo {
    //region Atributi
	@Id
	@Column(name = "delo_id")
	@GeneratedValue
	private Long id;
	
    @Column
    private String naziv;
    @Column
    @ElementCollection(targetClass = String.class)
    private ArrayList<String> glumci;
    @Column
    private String zanr;
    @Column
    private String reditelj;
    @Column
    private float trajanje;
    @Column
    private SerialBlob poster;
    @Column
    private String opis;
    @OneToMany
	@JoinColumn(name = "projekcija_id")
    private ArrayList<Projekcija> projekcije;
    @Column
    private float cena;
    //endregion
	
	
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
	
	public ArrayList<String> getGlumci() {
		return glumci;
	}
	
	public void setGlumci(ArrayList<String> glumci) {
		this.glumci = glumci;
	}
	
	public String getZanr() {
		return zanr;
	}
	
	public void setZanr(String zanr) {
		this.zanr = zanr;
	}
	
	public String getReditelj() {
		return reditelj;
	}
	
	public void setReditelj(String reditelj) {
		this.reditelj = reditelj;
	}
	
	public float getTrajanje() {
		return trajanje;
	}
	
	public void setTrajanje(float trajanje) {
		this.trajanje = trajanje;
	}
	
	public SerialBlob getPoster() {
		return poster;
	}
	
	public void setPoster(SerialBlob poster) {
		this.poster = poster;
	}
	
	public String getOpis() {
		return opis;
	}
	
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	public ArrayList<Projekcija> getProjekcije() {
		return projekcije;
	}
	
	public void setProjekcije(ArrayList<Projekcija> projekcije) {
		this.projekcije = projekcije;
	}
	
	public float getCena() {
		return cena;
	}
	
	public void setCena(float cena) {
		this.cena = cena;
	}
}
