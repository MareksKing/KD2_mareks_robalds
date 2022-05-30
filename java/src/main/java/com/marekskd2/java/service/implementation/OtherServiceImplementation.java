package com.marekskd2.java.service.implementation;

import java.sql.Time;
import java.util.Collection;

import com.marekskd2.java.model.Channel;
import com.marekskd2.java.model.Film;
import com.marekskd2.java.model.MovieSession;
import com.marekskd2.java.model.MyUser;
import com.marekskd2.java.repo.IMovieSessionRepo;
import com.marekskd2.java.service.IOtherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtherServiceImplementation implements IOtherService{

    @Autowired
    private IMovieSessionRepo sessionRepo;


    @Override
    public Collection<MovieSession> selectAllSessionsByFilm(int id) throws Exception {
        return sessionRepo.findAllByFilmIdFilm(id);
    }

    @Override
    public Collection<MovieSession> selectAllSessionsByChannel(int id) throws Exception {
        return sessionRepo.findAllByChannelIdCh(id);
    }

    @Override
    public Collection<MovieSession> selectAllSessionsByUser(int id) throws Exception {
        return sessionRepo.findAllByUserIdUser(id);
    }

    @Override
    public Collection<MovieSession> selectAllLongSessions() throws Exception {
        return sessionRepo.findAllByFilmLengthGreaterThan(2.0f);
    }

    @Override
    public MovieSession createNewSession(Film film, Channel channel, MyUser user, String startTime, String endTime) throws Exception {
        MovieSession session = new MovieSession();
        session.setStartTime(Time.valueOf(startTime));
        session.setEndTime(Time.valueOf(endTime));
        session.setFilm(film);
        session.setChannel(channel);
        session.setMyUser(user);
        sessionRepo.save(session);
        return session;
    }
    
}
