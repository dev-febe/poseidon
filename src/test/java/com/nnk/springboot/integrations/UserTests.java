package com.nnk.springboot.integrations;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Test;
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
        User user = new User("bationo", "123456@Bonjour", "BATIONO Aristide", "User" );

        // Save
        user = userRepository.save(user);
        Assert.assertNotNull(user.getId());
        Assert.assertTrue(user.getFullname().equals("BATIONO Aristide"));

        // Update
        user.setFullname("Aristide");
        user = userRepository.save(user);
        Assert.assertTrue(user.getFullname().equals("Aristide"));

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
