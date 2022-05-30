package com.marekskd2.java.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class MovieSession{
    
    @Column(name = "idSession")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idSession;
    
    @Column(name = "End Time")
    private Time endTime;

    @Column(name = "Start Time")
    private Time startTime;

    @ManyToOne
    @JoinColumn(name = "idFilm")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private MyUser myUser;

    @ManyToOne
    @JoinColumn(name = "idCh")
    private Channel channel;

    public MovieSession(Time startTime, Time endTime, Film film, MyUser user, Channel channel) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.film = film;
        this.myUser = user;
        this.channel = channel;
    }


}
