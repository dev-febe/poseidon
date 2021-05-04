package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.services.RuleNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller for handle Rule CRUD
 */
@Controller
public class RuleNameController {
    RuleNameService ruleNameService;

    @Autowired
    RuleNameController(RuleNameService ruleNameService) {
        this.ruleNameService = ruleNameService;
    }

    /**
     * Read the list of all RuleName
     */
    @RequestMapping("/ruleName/list")
    public String showRuleList(Model model) {
        model.addAttribute("list", ruleNameService.list());
        return "ruleName/list";
    }

    /**
     * Show the add RuleName form
     */
    @GetMapping("/ruleName/add")
    public String showAddRuleForm(@ModelAttribute RuleName bid) {
        return "ruleName/add";
    }

    /**
     * Add a new RuleName to DB
     */
    @PostMapping("/ruleName/validate")
    public String submitAddRuleForm(@Valid RuleName ruleName, BindingResult result) {
        //check model validation
        if (!result.hasErrors()) {
            ruleNameService.save(ruleName);
            return "redirect:/ruleName/list";
        }
        return "ruleName/add";
    }

    /**
     * Show the form for updating an existing RuleName
     */
    @GetMapping("/ruleName/update/{id}")
    public String showUpdateRuleForm(@PathVariable("id") Integer id, Model model) {
        //check that an id exists
        RuleName ruleName = ruleNameService.find(id);
        if (ruleName == null)
            throw new IllegalArgumentException("Invalid rating Id:" + id);
        model.addAttribute("ruleName", ruleName);
        return "ruleName/update";
    }

    /**
     * Update existing RuleName
     */
    @PostMapping("/ruleName/update/{id}")
    public String submitUpdateRuleForm(
            @PathVariable("id") Integer id,
            @Valid RuleName ruleName,
            BindingResult result
    ) {
        if (!result.hasErrors()) {
            ruleName.setId(id);
            ruleNameService.save(ruleName);
            return "redirect:/ruleName/list";
        }
        return "ruleName/update";
    }

    /**
     * Delete an existing RuleName
     */
    @GetMapping("/ruleName/delete/{id}")
    public String deleteRule(@PathVariable("id") Integer id) {
        RuleName ruleName = ruleNameService.find(id);
        if (ruleName == null)
            throw new IllegalArgumentException("Invalid bid Id:" + id);
        ruleNameService.delete(id);
        return "redirect:/ruleName/list";
    }
}
