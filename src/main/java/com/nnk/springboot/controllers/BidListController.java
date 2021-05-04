package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.services.BidListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * Controller for handle Bid CRUD
 */
@Controller
public class BidListController {
    BidListService bidListService;

    @Autowired
    BidListController(BidListService bidListService) {
        this.bidListService = bidListService;
    }

    /**
     * Read the list of all bid
     */
    @RequestMapping("/bidList/list")
    public String showBdList(Model model) {
        model.addAttribute("list", bidListService.list());
        return "bidList/list";
    }

    /**
     * Show the add Bid form
     */
    @GetMapping("/bidList/add")
    public String showAddBidForm(@ModelAttribute BidList bid) {
        return "bidList/add";
    }

    /**
     * Add a new Bid to DB
     */
    @PostMapping("/bidList/add")
    public String submitAddBidForm(@Valid BidList bid, BindingResult result) {
        //check model validation
        if (!result.hasErrors()) {
            bidListService.save(bid);
            return "redirect:/bidList/list";
        }
        return "bidList/add";
    }

    /**
     * Show the form for updating an existing Bid
     */
    @GetMapping("/bidList/update/{id}")
    public String showUpdateBidForm(@PathVariable("id") Integer id, Model model) {
        //check that id exists
        BidList bid = bidListService.find(id);
        if (bid == null)
            throw new IllegalArgumentException("Invalid bid Id:" + id);
        model.addAttribute("bidList", bid);
        return "bidList/update";
    }

    /**
     * Update existing Bid
     */
    @PostMapping("/bidList/update/{id}")
    public String submitUpdateBidForm(
            @PathVariable("id") Integer id,
            @Valid BidList bidList,
            BindingResult result
    ) {
        if (!result.hasErrors()) {
            bidList.setId(id);
            bidListService.save(bidList);
            return "redirect:/bidList/list";
        }
        return "bidList/update";
    }

    /**
     * Delete an existing Bid
     */
    @GetMapping("/bidList/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id) {
        BidList bid = bidListService.find(id);
        if (bid == null)
            throw new IllegalArgumentException("Invalid bid Id:" + id);
        bidListService.delete(id);
        return "redirect:/bidList/list";
    }
}
