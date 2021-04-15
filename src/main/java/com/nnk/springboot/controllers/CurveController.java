package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.services.CurveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class CurveController {
    @Autowired
    CurveService curveService;

    @RequestMapping("/curvePoint/list")
    public String home(Model model) {
        model.addAttribute("list", curveService.list());
        return "curvePoint/list";
    }

    @GetMapping("/curvePoint/add")
    public String addBidForm(CurvePoint bid) {
        return "curvePoint/add";
    }

    @PostMapping("/curvePoint/validate")
    public String validate(@Valid CurvePoint curvePoint, BindingResult result, Model model) {
        //check model validation
        if (!result.hasErrors()) {
            curveService.save(curvePoint);
            return "redirect:/curvePoint/list";
        }
        return "curvePoint/add";
    }

    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        //check that an id exists
        CurvePoint curvePoint = curveService.find(id);
        if (curvePoint == null)
            new IllegalArgumentException("Invalid curvePoint Id:" + id);
        model.addAttribute("curvePoint", curvePoint);

        return "curvePoint/update";
    }

    @PostMapping("/curvePoint/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint,
                            BindingResult result, Model model) {
        if (!result.hasErrors()) {
            curvePoint.setId(id);
            curveService.save(curvePoint);
            return "redirect:/curvePoint/list";
        }
        return "curvePoint/update";
    }

    @GetMapping("/curvePoint/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        CurvePoint curvePoint = curveService.find(id);
        if (curvePoint == null)
            new IllegalArgumentException("Invalid bid Id:" + id);
        curveService.delete(id);
        return "redirect:/curvePoint/list";
    }
}
