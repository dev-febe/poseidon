package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidListService {
    @Autowired
    BidListRepository bidListRepository;

    public BidList save(BidList bidList) {
        return bidListRepository.save(bidList);
    }

    public BidList find(int id) {
        return bidListRepository.findById(id);
    }

    public List<BidList> list() {
        return bidListRepository.findAll();
    }

    public void delete(int id) {
        bidListRepository.delete(find(id));
    }
}
