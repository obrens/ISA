package isa.projekat.model;

import javax.persistence.*;
import javax.sql.rowset.serial.SerialBlob;
import java.util.Set;

@Entity
public class Delo {
	//region Atributi
	@Id
	@Column(name = "delo_id")
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ustanova_id")
	private Ustanova ustanova;
	@Column
	private String naziv;
	//@Column
	//@ElementCollection(targetClass = String.class)
	//private ArrayList<String> glumci;
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
	//@OneToMany(mappedBy = "delo")
	//private Set<Projekcija> projekcije;
	@Column
	private float cena;
	//endregion
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Ustanova getUstanova() {
		return ustanova;
	}
	
	public void setUstanova(Ustanova ustanova) {
		this.ustanova = ustanova;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
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
	
	/*public Set<Projekcija> getProjekcije() {
		return projekcije;
	}
	
	public void setProjekcije(Set<Projekcija> projekcije) {
		this.projekcije = projekcije;
	}*/
	
	public float getCena() {
		return cena;
	}
	
	public void setCena(float cena) {
		this.cena = cena;
	}
}
