package isa.projekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sala {
	@Id
	@Column(name = "sala_id")
	@GeneratedValue
	private Long id;
	
    @Column
    private String nazivSale;
    @Column
    private int brojRedova;
    @Column
    private int brojKolona;
}
