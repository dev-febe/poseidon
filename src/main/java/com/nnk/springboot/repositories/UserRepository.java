package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    /**
     * Save a new Bid
     */
    User save(User user);

    /**
     * Find a specific Bid by Id
     */
    User findById(int id);

    /**
     * Find all Bid saved
     */
    List<User> findAll();

    /**
     * Delete a Bid by a specific Id
     */
    void delete(User user);
}
