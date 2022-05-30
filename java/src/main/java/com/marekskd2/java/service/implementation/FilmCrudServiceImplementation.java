package com.marekskd2.java.service.implementation;

import java.util.Collection;

import com.marekskd2.java.model.Film;
import com.marekskd2.java.repo.IFilmRepo;
import com.marekskd2.java.service.IFilmCRUDService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmCrudServiceImplementation implements IFilmCRUDService{

    @Autowired
    private IFilmRepo filmRepo;


    @Override
    public Film insertFilm(Film film) throws Exception {
        if(filmRepo.existsById(film.getIdFilm())){throw new Exception("Filma jau ir datu bāzē");}
        return filmRepo.save(film);
    }

    @Override
    public void updateFilmById(int id, Film film) throws Exception {
        if(!filmRepo.existsById(id)){throw new Exception("Filma nav datu bāzē");}
        Film filmToUpdate = filmRepo.findById(id).get();
        if(!filmToUpdate.getFilmType().equals(film.getFilmType())){filmToUpdate.setFilmType(film.getFilmType());}
        if(!filmToUpdate.getTitle().equals(film.getTitle())){filmToUpdate.setTitle(film.getTitle());}
        if(filmToUpdate.getLenght() != film.getLenght()){filmToUpdate.setLenght(film.getLenght());}
        
    }

    @Override
    public void deleteFilmById(int id) throws Exception {
        if(!filmRepo.existsById(id)){throw new Exception("Filma nav datu bāzē vai jau izdzēsta");}
        filmRepo.deleteById(id);
        
    }

    @Override
    public Film selectFilmById(int id) throws Exception {
        if(!filmRepo.existsById(id)){throw new Exception("Filma nav datu bāzē apsveriet to pievienot");}
        return filmRepo.findById(id).get();
    }

    @Override
    public Collection<Film> selectAll() {
        return (Collection<Film>) filmRepo.findAll();
    }
    
}
