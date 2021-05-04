package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BidListServiceTest {
    @Mock
    BidListRepository repository;

    @InjectMocks
    BidListService service;

    @Test
    public void save_ShouldSuccess() {
        BidList toSave = new BidList();
        Mockito.when(repository.save(toSave)).thenReturn(toSave);
        service.save(toSave);
    }

    @Test
    public void find_ShouldSuccess() {
        BidList toSave = new BidList();
        Mockito.when(repository.findById(1)).thenReturn(toSave);

        service.find(1);
    }

    @Test
    public void list_ShouldSuccess() {
        service.list();
    }

    @Test
    public void delete_ShouldSuccess() {
        BidList toSave = new BidList();
        Mockito.when(repository.findById(1)).thenReturn(toSave);

        service.delete(1);
    }
}
