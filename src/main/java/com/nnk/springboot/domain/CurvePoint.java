package com.nnk.springboot.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "curvepoint")
public class CurvePoint {
    @Id
    @GeneratedValue
    private int id;
    @Min(message = "curveId property should not be null", value = 1 )
    private int curveId;
    private Date asOfDate;
    @DecimalMin(message = "term property should not be null", value = "0.01" )
    private double term;
    @DecimalMin(message = "value property should not be null", value = "0.01" )
    private double value;
    private Date creationDate;

    public CurvePoint(int curveId, double term, double value) {
        this.curveId = curveId;
        this.term = term;
        this.value = value;
    }
}
