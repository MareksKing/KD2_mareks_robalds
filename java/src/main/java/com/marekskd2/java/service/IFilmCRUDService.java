package com.marekskd2.java.service;

import java.util.Collection;

import com.marekskd2.java.model.Film;

public interface IFilmCRUDService {
    
    public abstract Film insertFilm(Film film) throws Exception;

    public abstract void updateFilmById(int id, Film film) throws Exception;

    public abstract void deleteFilmById(int id) throws Exception;

    public abstract Film selectFilmById(int id) throws Exception;

    public abstract Collection<Film> selectAll();
}
