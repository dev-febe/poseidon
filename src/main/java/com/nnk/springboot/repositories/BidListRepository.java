package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.BidList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BidListRepository extends JpaRepository<BidList, Integer> {
    /**
     * Save a new Bid
     */
    BidList save(BidList bidList);

    /**
     * Find a specific Bid by Id
     */
    BidList findById(int id);

    /**
     * Find all Bid saved
     */
    List<BidList> findAll();

    /**
     * Delete a Bid by a specific Id
     */
    void delete(BidList bidList);
}
