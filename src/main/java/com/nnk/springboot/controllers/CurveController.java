package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.services.CurveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller for handle Curve CRUD
 */
@Controller
public class CurveController {
    CurveService curveService;

    @Autowired
    CurveController(CurveService curveService) {
        this.curveService = curveService;
    }

    /**
     * Read the list of all curvePoint
     */
    @RequestMapping("/curvePoint/list")
    public String showCurvePointList(Model model) {
        model.addAttribute("list", curveService.list());
        return "curvePoint/list";
    }

    /**
     * Show the add CurvePoint form
     */
    @GetMapping("/curvePoint/add")
    public String addCurvePointForm(@ModelAttribute CurvePoint bid) {
        return "curvePoint/add";
    }

    /**
     * Add a new CurvePoint to DB
     */
    @PostMapping("/curvePoint/validate")
    public String submitAddCurvePointForm(@Valid CurvePoint curvePoint, BindingResult result) {
        //check model validation
        if (!result.hasErrors()) {
            curveService.save(curvePoint);
            return "redirect:/curvePoint/list";
        }
        return "curvePoint/add";
    }

    /**
     * Show the form for updating an existing CurvePoint
     */
    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateCurvePointForm(@PathVariable("id") Integer id, Model model) {
        //check that an id exists
        CurvePoint curvePoint = curveService.find(id);
        if (curvePoint == null)
            throw new IllegalArgumentException("Invalid curvePoint Id:" + id);
        model.addAttribute("curvePoint", curvePoint);

        return "curvePoint/update";
    }

    /**
     * Update existing CurvePoint
     */
    @PostMapping("/curvePoint/update/{id}")
    public String submitUpdateCurvePointForm(
            @PathVariable("id") Integer id,
            @Valid CurvePoint curvePoint,
            BindingResult result
    ) {
        if (!result.hasErrors()) {
            curvePoint.setId(id);
            curveService.save(curvePoint);
            return "redirect:/curvePoint/list";
        }
        return "curvePoint/update";
    }

    /**
     * Delete an existing CurvePoint
     */
    @GetMapping("/curvePoint/delete/{id}")
    public String deleteCurvePoint(@PathVariable("id") Integer id) {
        CurvePoint curvePoint = curveService.find(id);
        if (curvePoint == null)
            throw new IllegalArgumentException("Invalid bid Id:" + id);
        curveService.delete(id);
        return "redirect:/curvePoint/list";
    }
}
