package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.services.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller for handle Trade CRUD
 */
@Controller
public class TradeController {
    TradeService tradeService;

    @Autowired
    TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    /**
     * Read the list of all Trade
     */
    @RequestMapping("/trade/list")
    public String showTradeList(Model model) {
        model.addAttribute("list", tradeService.list());
        return "trade/list";
    }

    /**
     * Show the add Trade form
     */
    @GetMapping("/trade/add")
    public String showAddTradeForm(@ModelAttribute Trade bid) {
        return "trade/add";
    }

    /**
     * Add a new Trade to DB
     */
    @PostMapping("/trade/validate")
    public String submitAddTradeForm(@Valid Trade trade, BindingResult result, Model model) {
        //check model validation
        if (!result.hasErrors()) {
            tradeService.save(trade);
            return "redirect:/trade/list";
        }
        return "trade/add";
    }

    /**
     * Show the form for updating an existing Trade
     */
    @GetMapping("/trade/update/{id}")
    public String showUpdateTradeForm(@PathVariable("id") Integer id, Model model) {
        //check that an id exists
        Trade trade = tradeService.find(id);
        if (trade == null)
            throw new IllegalArgumentException("Invalid trade Id:" + id);
        model.addAttribute("trade", trade);
        return "trade/update";
    }

    /**
     * Update existing Trade
     */
    @PostMapping("/trade/update/{id}")
    public String submitUpdateTradeForm(
            @PathVariable("id") Integer id,
            @Valid Trade trade,
            BindingResult result
    ) {
        if (!result.hasErrors()) {
            trade.setId(id);
            tradeService.save(trade);
            return "redirect:/trade/list";
        }
        return "redirect:/trade/list";
    }

    /**
     * Delete an existing Trade
     */
    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id) {
        Trade trade = tradeService.find(id);
        if (trade == null)
            throw new IllegalArgumentException("Invalid trade Id:" + id);
        tradeService.delete(id);
        return "redirect:/trade/list";
    }
}
