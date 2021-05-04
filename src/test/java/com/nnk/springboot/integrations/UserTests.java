package com.nnk.springboot.integrations;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void userTest() {
        User user = new User("ben", "123456@Bonjour", "Kone Ben Fousseni", "User" );

        // Save
        user = userRepository.save(user);
        Assert.assertNotNull(user.getId());
        Assert.assertEquals("Kone Ben Fousseni", user.getFullname());

        // Update
        user.setFullname("Aristide");
        user = userRepository.save(user);
        Assert.assertEquals("Aristide", user.getFullname());

        // Find
        List<User> listResult = userRepository.findAll();
        Assert.assertTrue(listResult.size() > 0);

        // Delete
        Integer id = user.getId();
        userRepository.delete(user);
        User userFound = userRepository.findById(id).orElse(null);
        Assert.assertNull(userFound);
    }
}
