package com.marekskd2.java.controller;

import java.util.Collection;

import javax.validation.Valid;

import com.marekskd2.java.model.Film;
import com.marekskd2.java.service.IFilmCRUDService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/film")
public class FilmCRUDController {
    
    @Autowired
    private IFilmCRUDService filmCRUDService;

    @GetMapping("/addNewFilm")
    public String addNewFilm(Film film){
        return "add-new-film-page";
    }

    @PostMapping("/addNewFilm")
    public String postAddNewFilm(@Valid Film film, BindingResult result, Model model){
        if(result.hasErrors()){return "add-new-film-page";}
        
        try {
            filmCRUDService.insertFilm(film);
            return "redirect:/film/list-page"; 
        } catch (Exception e) {
            model.addAttribute("errorMSG", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/updateFilmById/{id}")
    public String updateFilmById(@PathVariable(name = "id") int id, Model model){
        try {
            Film filmToUpdate = filmCRUDService.selectFilmById(id);
            model.addAttribute("packet", filmToUpdate);
            return "film-update-page";
          } catch (Exception e) {
            model.addAttribute("errorMSG", e.getMessage());
            return "error-page";
          }
    }

    @PostMapping("/updateFilmById/{id}")
    public String postUpdateFilmById(@PathVariable(name = "id")int id, @Valid Film film, BindingResult result, Model model){
        if(result.hasErrors()){return "film-update-page";}
        
        try {
            filmCRUDService.updateFilmById(id, film);
            return "redirect:/film/list-page"; 
        } catch (Exception e) {
            model.addAttribute("errorMSG", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/deleteFilmById/{id}")
    public String deleteFilmById(@PathVariable(name = "id") int id, Model model){
        try {
            filmCRUDService.deleteFilmById(id);
            return "redirect:/film/list-page"; 
        } catch (Exception e) {
            model.addAttribute("errorMSG", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/showAllFilms")
    public String listPage(Model model){
        try {
            Collection<Film> films = filmCRUDService.selectAll();
            model.addAttribute("films", films);
            return "list-page";
        } catch (Exception e) {
            model.addAttribute("errorMSG", e.getMessage());
            return "error-page";
        }
    }



}
