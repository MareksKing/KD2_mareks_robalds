package com.marekskd2.java.repo;

import com.marekskd2.java.model.Film;

import org.springframework.data.repository.CrudRepository;

public interface IFilmRepo extends CrudRepository<Film, Integer> {

}

