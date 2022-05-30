package com.marekskd2.java.controller;

import java.util.Collection;

import javax.validation.Valid;

import com.marekskd2.java.model.Channel;
import com.marekskd2.java.model.Film;
import com.marekskd2.java.model.MovieSession;
import com.marekskd2.java.model.MyUser;
import com.marekskd2.java.service.IFilmCRUDService;
import com.marekskd2.java.service.IOtherService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/session")
public class OtherServiceController {
    
    @Autowired
    private IOtherService otherService;

    @GetMapping("/list/filmPage/{id}")
    public String listFilmPage(@PathVariable(name = "id") int id, Model model){
        try {
            Collection<MovieSession> sessions = otherService.selectAllSessionsByFilm(id);
            model.addAttribute("packet", sessions);
            return "sessions-film-list-page";
        } catch (Exception e) {
            model.addAttribute("errorMSG", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/list/channelPage/{id}")
    public String listChannelPage(@PathVariable(name = "id") int id, Model model){
        try {
            Collection<MovieSession> sessions = otherService.selectAllSessionsByChannel(id);
            model.addAttribute("packet", sessions);
            return "sessions-channel-list-page";
        } catch (Exception e) {
            model.addAttribute("errorMSG", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/list/userPage/{id}")
    public String listUserPage(@PathVariable(name = "id") int id, Model model){
        try {
            Collection<MovieSession> sessions = otherService.selectAllSessionsByUser(id);
            model.addAttribute("packet", sessions);
            return "sessions-user-list-page";
        } catch (Exception e) {
            model.addAttribute("errorMSG", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/list/longSession")
    public String listLongSessionPage(Model model){
        try {
            Collection<MovieSession> sessions = otherService.selectAllLongSessions();
            model.addAttribute("packet", sessions);
            return "sessions-long-list-page";
        } catch (Exception e) {
            model.addAttribute("errorMSG", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/createNewSession")
    public String createNewSession(Film film, Channel channel, MyUser user, String startTime, String endTime){
        return "create-new-session-page";
    }

    @PostMapping("/createNewSession")
    public String postCreateNewSession(@Valid Film film, @Valid Channel channel, @Valid MyUser user, String startTime, String endTime, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("errorMSG", result.getAllErrors());
            return "create-new-session-page";
        }
        try {
            MovieSession session = otherService.createNewSession(film, channel, user, startTime, endTime);
            model.addAttribute("packet", session);
            return "session-created-page";
        } catch (Exception e) {
            model.addAttribute("errorMSG", e.getMessage());
            return "error-page";
        }
    }


}
