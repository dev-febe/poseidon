package com.nnk.springboot.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Entity
@Table(name = "rulename")
public class RuleName {
    @Id
    @GeneratedValue
    private int id;
    @NotBlank(message = "name property should not be blank")
    private String name;
    @NotBlank(message = "description property should not be blank")
    private String description;
    @NotBlank(message = "json property should not be blank")
    private String json;
    @NotBlank(message = "template property should not be blank")
    private String template;
    @NotBlank(message = "sqlStr property should not be blank")
    private String sqlStr;
    @NotBlank(message = "sqlPart property should not be blank")
    private String sqlPart;

    public RuleName(String name, String description, String json, String template, String sqlStr, String sqlPart) {
        this.name = name;
        this.description = description;
        this.json = json;
        this.template = template;
        this.sqlStr = sqlStr;
        this.sqlPart = sqlPart;
    }
}
