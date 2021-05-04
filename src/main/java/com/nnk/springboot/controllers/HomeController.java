package com.nnk.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for handle home request
 */
@Controller
public class HomeController {
    /**
     * Get home page
     */
    @RequestMapping("/")
    public String home() {
        return "home";
    }

    /**
     * Get admin page
     */
    @RequestMapping("/admin/home")
    public String adminHome() {
        return "redirect:/bidList/list";
    }
}
