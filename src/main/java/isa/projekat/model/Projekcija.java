package isa.projekat.model;

import jdk.nashorn.internal.ir.annotations.Reference;

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
	
	@ManyToOne
	@JoinColumn
	private Delo delo;
	
	@Column
	private Sala sala;
	
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
	
	public Delo getDelo() {
		return delo;
	}
	
	public void setDelo(Delo delo) {
		this.delo = delo;
	}
	
	public Sala getSala() {
		return sala;
	}
	
	public void setSala(Sala sala) {
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
