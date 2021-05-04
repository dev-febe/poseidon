package com.nnk.springboot.integrations;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.services.RatingService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RatingTests {

    @Autowired
    private RatingService ratingService;

    @Test
    public void ratingTest() {
        Rating rating = new Rating("Moodys Rating", "Sand PRating", "Fitch Rating", 10);

        // Save
        rating = ratingService.save(rating);
        Assert.assertEquals(10, rating.getOrderNumber());

        // Update
        rating.setOrderNumber(20);
        rating = ratingService.save(rating);
        Assert.assertEquals(20, rating.getOrderNumber());

        // Find
        List<Rating> listResult = ratingService.list();
        Assert.assertTrue(listResult.size() > 0);

        // Delete
        Integer id = rating.getId();
        ratingService.delete(id);
        Rating ratingList = ratingService.find(id);
        Assert.assertNull(ratingList);
    }
}
