package isa.projekat.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Set;

@Entity
public class Projekcija {
	@Id
	@Column(name = "projekcija_id")
	@GeneratedValue
	private Long id;
	
	@ManyToMany
	private Set<Sala> sala;
	
	@Column
	private Date datum;
	
	@Column
	private Time vreme;
	
	@Column
	private float cena;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Set<Sala> getSala() {
		return sala;
	}
	
	public void setSala(Set<Sala> sala) {
		this.sala = sala;
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
	
	public float getCena() {
		return cena;
	}
	
	public void setCena(float cena) {
		this.cena = cena;
	}
}
