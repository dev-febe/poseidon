package com.nnk.springboot.services;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    RatingRepository ratingRepository;

    @Autowired
    RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    /**
     * Save a new Rating
     */
    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }


    /**
     * Find a specific Rating by Id
     */
    public Rating find(int id) {
        return ratingRepository.findById(id);
    }

    /**
     * List all Rating
     */
    public List<Rating> list() {
        return ratingRepository.findAll();
    }

    /**
     * Delete a specific Rating by Id
     */
    public void delete(int id) {
        ratingRepository.delete(find(id));
    }
}
