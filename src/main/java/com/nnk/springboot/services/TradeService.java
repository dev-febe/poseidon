package com.nnk.springboot.services;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService {
    TradeRepository tradeRepository;

    @Autowired
    TradeService(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    /**
     * Save a new Trade
     */
    public Trade save(Trade trade) {
        return tradeRepository.save(trade);
    }

    /**
     * Find a specific Trade by Id
     */
    public Trade find(int id) {
        return tradeRepository.findById(id);
    }

    /**
     * List all Trade
     */
    public List<Trade> list() {
        return tradeRepository.findAll();
    }

    /**
     * Delete a specific Trade by Id
     */
    public void delete(int id) {
        tradeRepository.delete(find(id));
    }
}
