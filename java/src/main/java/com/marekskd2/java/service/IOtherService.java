package com.marekskd2.java.service;

import java.util.Collection;

import com.marekskd2.java.model.Channel;
import com.marekskd2.java.model.Film;
import com.marekskd2.java.model.MovieSession;
import com.marekskd2.java.model.MyUser;

public interface IOtherService {
    
    public abstract Collection<MovieSession> selectAllSessionsByFilm(int id) throws Exception;

    public abstract Collection<MovieSession> selectAllSessionsByChannel(int id) throws Exception;

    public abstract Collection<MovieSession> selectAllSessionsByUser(int id) throws Exception;

    public abstract Collection<MovieSession> selectAllLongSessions() throws Exception;

    public abstract MovieSession createNewSession(Film film, Channel channel, MyUser user, String startTime, String endTime) throws Exception;
}
