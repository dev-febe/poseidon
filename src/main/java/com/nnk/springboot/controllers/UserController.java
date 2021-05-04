package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller for handle User CRUD
 */
@Controller
public class UserController {
    UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Read the list of all User
     */
    @RequestMapping("/user/list")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.list());
        return "user/list";
    }

    /**
     * Show the add User form
     */
    @GetMapping("/user/add")
    public String showAddUserForm(@ModelAttribute User bid) {
        return "user/add";
    }

    /**
     * Add a new User to DB
     */
    @PostMapping("/user/add")
    public String submitAddUserForm(@Valid User user, BindingResult result, Model model) {
        //check model validation
        if (!result.hasErrors()) {
            userService.save(user);
            model.addAttribute("users", userService.list());
            return "redirect:/user/list";
        }
        return "user/add";
    }

    /**
     * Show the form for updating an existing User
     */
    @GetMapping("/user/update/{id}")
    public String showUpdateUserForm(@PathVariable("id") Integer id, Model model) {
        User user = userService.find(id);
        user.setPassword("");
        model.addAttribute("user", user);
        return "user/update";
    }

    /**
     * Update an existing User
     */
    @PostMapping("/user/update/{id}")
    public String submitUpdateUserForm(
            @PathVariable("id") Integer id,
            @Valid User user,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return "user/update";
        }
        userService.save(user);
        model.addAttribute("users", userService.list());
        return "redirect:/user/list";
    }

    /**
     * Delete an existing User
     */
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
        userService.delete(id);
        model.addAttribute("users", userService.list());
        return "redirect:/user/list";
    }
}
