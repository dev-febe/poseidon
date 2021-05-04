package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.RuleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RuleNameRepository extends JpaRepository<RuleName, Integer> {
    RuleName save(RuleName ruleName);
    RuleName findById(int id);
    List<RuleName> findAll();
    void delete(RuleName ruleName);
}
