package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class for handle BidRepository logic
 */
@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Save a new bid
     */
    public User save(User user) {
        //encode password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);

        return userRepository.save(user);
    }


    /**
     * Find a specific Bid by Id
     */
    public User find(int id) {
        return userRepository.findById(id);
    }

    /**
     * List all Bid
     */
    public List<User> list() {
        return userRepository.findAll();
    }

    /**
     * Delete a specific Bid by Id
     */
    public void delete(int id) {
        userRepository.delete(find(id));
    }
}
