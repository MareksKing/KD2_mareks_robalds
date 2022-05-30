package com.marekskd2.java;

import java.sql.Time;

import com.marekskd2.java.model.Channel;
import com.marekskd2.java.model.Film;
import com.marekskd2.java.model.FilmType;
import com.marekskd2.java.model.MovieSession;
import com.marekskd2.java.model.MyUser;
import com.marekskd2.java.repo.IChannelRepo;
import com.marekskd2.java.repo.IFilmRepo;
import com.marekskd2.java.repo.IMovieSessionRepo;
import com.marekskd2.java.repo.IUserRepo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaApplication.class, args);
	}

	@Bean //visur kur si annotacija, tiks izsaukts automatiski
	public CommandLineRunner cmdLineRunner(IFilmRepo filmRepo, IUserRepo userRepo, IChannelRepo channelRepo, IMovieSessionRepo sessionRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {

				Film film1 = new Film("Titanic", 3.00f, FilmType.romance);
				Film film2 = new Film("The Godfather", 2.34f, FilmType.action);
				Film film3 = new Film("The Shawshank Redemption", 1.30f, FilmType.thriller);

				filmRepo.save(film1);
				filmRepo.save(film2);
				filmRepo.save(film3);

				MyUser es = new MyUser("robaldsmareks@gmail.com", "Mareks", "Robalds");
				MyUser tu = new MyUser("tu.esi@inbox.lv", "Tu", "Esi");
				MyUser vins = new MyUser("vins.but@yahoo.lv", "Vins", "Buts");

				userRepo.save(es);
				userRepo.save(tu);
				userRepo.save(vins);

				Channel channel1 = new Channel(true, "Latviesu", "LTV1");
				Channel channel2 = new Channel(true, "Latviesu", "LTV2");
				Channel channel3 = new Channel(true, "Latviesu", "TV3");
				Channel channel4 = new Channel(false, "Vacu", "LTV4");
				Channel channel5 = new Channel(false, "Krievu", "Ru24");
				Channel channel6 = new Channel(true, "Latviesu", "TV6");

				channelRepo.save(channel1);
				channelRepo.save(channel2);
				channelRepo.save(channel3);
				channelRepo.save(channel4);
				channelRepo.save(channel5);
				channelRepo.save(channel6);

				MovieSession session1 = new MovieSession(Time.valueOf("21:10"), Time.valueOf("23:55"), film1, tu, channel1);
				MovieSession session2 = new MovieSession(Time.valueOf("21:10"), Time.valueOf("23:55"), film1, vins, channel1);
				MovieSession session3 = new MovieSession(Time.valueOf("20:10"), Time.valueOf("22:00"), film2, es, channel2);
				MovieSession session4 = new MovieSession(Time.valueOf("12:10"), Time.valueOf("14:00"), film3, vins, channel3);

				sessionRepo.save(session1);
				sessionRepo.save(session2);
				sessionRepo.save(session3);
				sessionRepo.save(session4);
			}
		};

	}
}
