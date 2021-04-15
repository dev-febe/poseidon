package com.nnk.springboot.services;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService {
    @Autowired
    TradeRepository tradeRepository;

    public Trade save(Trade trade) {
        return tradeRepository.save(trade);
    }

    public Trade find(int id) {
        return tradeRepository.findById(id);
    }

    public List<Trade> list() {
        return tradeRepository.findAll();
    }

    public void delete(int id) {
        tradeRepository.delete(find(id));
    }
}
