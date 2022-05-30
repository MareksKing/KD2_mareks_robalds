package com.marekskd2.java.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
public class Film {
    
    @Column(name = "idFilm")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idFilm;

    @Column(name = "Length")
    private float lenght;

    @Column(name = "FilmType")
    private FilmType filmType;

    @Column(name = "Title")
    private String title;

    @OneToMany(mappedBy = "film")
    @ToString.Exclude
    private Collection<MovieSession> movieSession;

    public Film(String title, float lenght, FilmType filmType) {
        this.lenght = lenght;
        this.filmType = filmType;
        this.title = title;
    }
}
