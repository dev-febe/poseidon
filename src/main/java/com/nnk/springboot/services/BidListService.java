package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class for handle BidRepository logic
 */
@Service
public class BidListService {
    BidListRepository bidListRepository;

    @Autowired
    BidListService(BidListRepository bidListRepository) {
        this.bidListRepository = bidListRepository;
    }

    /**
     * Save a new bid
     */
    public BidList save(BidList bidList) {
        return bidListRepository.save(bidList);
    }

    /**
     * Find a specific Bid by Id
     */
    public BidList find(int id) {
        return bidListRepository.findById(id);
    }

    /**
     * List all Bid
     */
    public List<BidList> list() {
        return bidListRepository.findAll();
    }

    /**
     * Delete a specific Bid by Id
     */
    public void delete(int id) {
        bidListRepository.delete(find(id));
    }
}
