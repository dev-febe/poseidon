package com.nnk.springboot.services;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleNameService {
    RuleNameRepository ruleNameRepository;

    @Autowired
    RuleNameService(RuleNameRepository ruleNameRepository) {
        this.ruleNameRepository = ruleNameRepository;
    }

    /**
     * Save a new RuleName
     */
    public RuleName save(RuleName ruleName) {
        return ruleNameRepository.save(ruleName);
    }


    /**
     * Find a specific RuleName by Id
     */
    public RuleName find(int id) {
        return ruleNameRepository.findById(id);
    }

    /**
     * List all RuleName
     */
    public List<RuleName> list() {
        return ruleNameRepository.findAll();
    }

    /**
     * Delete a specific RuleName by Id
     */
    public void delete(int id) {
        ruleNameRepository.delete(find(id));
    }
}
