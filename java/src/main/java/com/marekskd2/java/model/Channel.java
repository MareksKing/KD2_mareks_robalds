package com.marekskd2.java.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;


@Getter
@Setter
@ToString
@NoArgsConstructor

@Table
@Entity
public class Channel {


    @Column(name = "idCh")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idCh;

    @Column(name = "VaiHD")
    private Boolean vaiHD;

    @Column(name = "Valoda")
    @Size(min = 4, max = 20)
    private String valoda;
    
    @Column(name = "Nosaukums")
    private String nosaukums;

    @OneToMany(mappedBy = "channel")
    @ToString.Exclude
    private Collection<MovieSession> movieSession;

    public Channel(Boolean vaiHD, String valoda, String nosaukums) {
        this.vaiHD = vaiHD;
        this.valoda = valoda;
        this.nosaukums = nosaukums;
    }


}
