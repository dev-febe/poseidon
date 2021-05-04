package com.nnk.springboot.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue
    private int id;
    @NotBlank(message = "moodysRating property should not be blank")
    private String moodysRating;
    @NotBlank(message = "sandPRating property should not be blank")
    private String sandPRating;
    @NotBlank(message = "fitchRating property should not be blank")
    private String fitchRating;
    @Min(message = "orderNumber property should not be null", value = 1 )
    private int orderNumber;

    public Rating(String moodysRating, String sandPRating, String fitchRating, int orderNumber) {
        this.moodysRating = moodysRating;
        this.sandPRating = sandPRating;
        this.fitchRating = fitchRating;
        this.orderNumber = orderNumber;
    }
}
