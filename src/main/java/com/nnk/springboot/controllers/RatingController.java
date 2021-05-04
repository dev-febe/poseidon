package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller for handle Rating CRUD
 */
@Controller
public class RatingController {
    RatingService ratingService;

    @Autowired
    RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    /**
     * Read the list of all Rating
     */
    @RequestMapping("/rating/list")
    public String showRatingList(Model model) {
        model.addAttribute("list", ratingService.list());
        return "rating/list";
    }

    /**
     * Show the add Rating form
     */
    @GetMapping("/rating/add")
    public String showAddRatingForm(@ModelAttribute Rating rating) {
        return "rating/add";
    }

    /**
     * Add a new Rating to DB
     */
    @PostMapping("/rating/add")
    public String submitAddRatingForm(@Valid Rating rating, BindingResult result) {
        //check model validation
        if (!result.hasErrors()) {
            ratingService.save(rating);
            return "redirect:/rating/list";
        }
        return "rating/add";
    }

    /**
     * Show the form for updating an existing Rating
     */
    @GetMapping("/rating/update/{id}")
    public String showUpdateRatingForm(@PathVariable("id") Integer id, Model model) {
        //check that an id exists
        Rating rating = ratingService.find(id);
        model.addAttribute("rating", rating);
        return "rating/update";
    }

    /**
     * Update existing Rating
     */
    @PostMapping("/rating/update/{id}")
    public String submitUpdateRatingForm(
            @PathVariable("id") Integer id,
            @Valid Rating rating,
            BindingResult result
    ) {
        if (!result.hasErrors()) {
            rating.setId(id);
            ratingService.save(rating);
            return "redirect:/rating/list";
        }
        return "rating/update";
    }

    /**
     * Delete an existing Rating
     */
    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id) {
        ratingService.delete(id);
        return "redirect:/rating/list";
    }
}
