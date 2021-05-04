package com.nnk.springboot.services;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepository repository;

    @InjectMocks
    UserService service;

    @Test
    public void save_ShouldSuccess() {
        User toSave = new User();
        toSave.setPassword("Passwor@121");
        Mockito.when(repository.save(toSave)).thenReturn(toSave);
        service.save(toSave);
    }

    @Test
    public void find_ShouldSuccess() {
        User toSave = new User();
        Mockito.when(repository.findById(1)).thenReturn(toSave);

        service.find(1);
    }

    @Test
    public void list_ShouldSuccess() {
        service.list();
    }

    @Test
    public void delete_ShouldSuccess() {
        User toSave = new User();
        Mockito.when(repository.findById(1)).thenReturn(toSave);

        service.delete(1);
    }
}
