package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.repositories.TradeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TradeServiceTest {
    @Mock
    TradeRepository repository;

    @InjectMocks
    TradeService service;

    @Test
    public void save_ShouldSuccess() {
        Trade toSave = new Trade();
        Mockito.when(repository.save(toSave)).thenReturn(toSave);
        service.save(toSave);
    }

    @Test
    public void find_ShouldSuccess() {
        Trade toSave = new Trade();
        Mockito.when(repository.findById(1)).thenReturn(toSave);

        service.find(1);
    }

    @Test
    public void list_ShouldSuccess() {
        service.list();
    }

    @Test
    public void delete_ShouldSuccess() {
        Trade toSave = new Trade();
        Mockito.when(repository.findById(1)).thenReturn(toSave);

        service.delete(1);
    }
}
