package com.nnk.springboot.services;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    @Autowired
    RatingRepository ratingRepository;

    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating find(int id) {
        return ratingRepository.findById(id);
    }

    public List<Rating> list() {
        return ratingRepository.findAll();
    }

    public void delete(int id) {
        ratingRepository.delete(find(id));
    }
}
