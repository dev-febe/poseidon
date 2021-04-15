package com.nnk.springboot.services;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurveService {
    @Autowired
    CurvePointRepository curvePointRepository;

    public CurvePoint save(CurvePoint curvePoint) {
        return curvePointRepository.save(curvePoint);
    }

    public CurvePoint find(int id) {
        return curvePointRepository.findById(id);
    }

    public List<CurvePoint> list() {
        return curvePointRepository.findAll();
    }

    public void delete(int id) {
        curvePointRepository.delete(find(id));
    }
}
