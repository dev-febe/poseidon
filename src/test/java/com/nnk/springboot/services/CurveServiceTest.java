package com.nnk.springboot.services;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CurveServiceTest {
    @Mock
    CurvePointRepository repository;

    @InjectMocks
    CurveService service;

    @Test
    public void save_ShouldSuccess() {
        CurvePoint toSave = new CurvePoint();
        Mockito.when(repository.save(toSave)).thenReturn(toSave);
        service.save(toSave);
    }

    @Test
    public void find_ShouldSuccess() {
        CurvePoint toSave = new CurvePoint();
        Mockito.when(repository.findById(1)).thenReturn(toSave);

        service.find(1);
    }

    @Test
    public void list_ShouldSuccess() {
        service.list();
    }

    @Test
    public void delete_ShouldSuccess() {
        CurvePoint toSave = new CurvePoint();
        Mockito.when(repository.findById(1)).thenReturn(toSave);

        service.delete(1);
    }
}
