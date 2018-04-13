package isa.projekat.model;

import javax.persistence.*;

@Entity
public class Sala {
	@Id
	@Column(name = "sala_id")
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ustanova_id")
	private Ustanova ustanova;
    @Column
    private String nazivSale;
    @Column
    private int brojRedova;
    @Column
    private int brojKolona;
	
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
	
	public String getNazivSale() {
		return nazivSale;
	}
	
	public void setNazivSale(String nazivSale) {
		this.nazivSale = nazivSale;
	}
	
	public int getBrojRedova() {
		return brojRedova;
	}
	
	public void setBrojRedova(int brojRedova) {
		this.brojRedova = brojRedova;
	}
	
	public int getBrojKolona() {
		return brojKolona;
	}
	
	public void setBrojKolona(int brojKolona) {
		this.brojKolona = brojKolona;
	}
}
