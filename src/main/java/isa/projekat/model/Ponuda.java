package isa.projekat.model;

import javax.persistence.*;

@Entity
public class Ponuda {
    @Id
    @Column (name = "ponuda_id")
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn
    private Rekvizit oglas;//oficijalni=false;

    @ManyToOne
    @JoinColumn
    private Korisnik ponudjac;

    @Column
    private float cena;


}
