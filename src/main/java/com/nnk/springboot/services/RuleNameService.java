package com.nnk.springboot.services;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleNameService {
    @Autowired
    RuleNameRepository ruleNameRepository;

    public RuleName save(RuleName ruleName) {
        return ruleNameRepository.save(ruleName);
    }

    public RuleName find(int id) {
        return ruleNameRepository.findById(id);
    }

    public List<RuleName> list() {
        return ruleNameRepository.findAll();
    }

    public void delete(int id) {
        ruleNameRepository.delete(find(id));
    }
}
