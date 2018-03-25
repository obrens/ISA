package isa.projekat.model;

import javax.persistence.*;
import javax.sql.rowset.serial.SerialBlob;
import java.time.ZonedDateTime;
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
    //TODO JoinColumn name = "naziv kolone"
    @OneToMany
	@JoinColumn(name = "sala_id")
    private ArrayList<Sala> saleProjekcije;
    @Column
	@ElementCollection(targetClass = ZonedDateTime.class)
    private ArrayList<ZonedDateTime> vremenaProjekcije;
    @Column
    private float cena;
    //endregion
}
