package com.nnk.springboot.services;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RuleNameServiceTest {
    @Mock
    RuleNameRepository repository;

    @InjectMocks
    RuleNameService service;

    @Test
    public void save_ShouldSuccess() {
        RuleName toSave = new RuleName();
        Mockito.when(repository.save(toSave)).thenReturn(toSave);
        service.save(toSave);
    }

    @Test
    public void find_ShouldSuccess() {
        RuleName toSave = new RuleName();
        Mockito.when(repository.findById(1)).thenReturn(toSave);

        service.find(1);
    }

    @Test
    public void list_ShouldSuccess() {
        service.list();
    }

    @Test
    public void delete_ShouldSuccess() {
        RuleName toSave = new RuleName();
        Mockito.when(repository.findById(1)).thenReturn(toSave);

        service.delete(1);
    }
}
