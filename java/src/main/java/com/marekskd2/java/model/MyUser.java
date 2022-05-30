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
public class MyUser{
    
    @Column(name = "idUser")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idUser;

    @Column(name = "Email")
    private String email;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @OneToMany(mappedBy = "myUser")
    @ToString.Exclude
    private Collection<MovieSession> movieSession;

    public MyUser(String email, String name, String surname) {
        this.email = email;
        this.name = name;
        this.surname = surname;
    }
}
