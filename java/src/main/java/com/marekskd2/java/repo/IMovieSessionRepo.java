package com.marekskd2.java.repo;

import java.util.Collection;

import com.marekskd2.java.model.Channel;
import com.marekskd2.java.model.Film;
import com.marekskd2.java.model.MovieSession;
import com.marekskd2.java.model.MyUser;

import org.springframework.data.repository.CrudRepository;

public interface IMovieSessionRepo extends CrudRepository<MovieSession, Integer> {

    Collection<MovieSession> findAllByFilmIdFilm(int id);

    Collection<MovieSession> findAllByChannelIdCh(int id);

    Collection<MovieSession> findAllByUserIdUser(int id);

    Collection<MovieSession> findAllByFilmLengthGreaterThan(float f);

    

}

