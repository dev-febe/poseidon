package com.nnk.springboot.services;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurveService {
    CurvePointRepository curvePointRepository;

    @Autowired
    CurveService(CurvePointRepository curvePointRepository) {
        this.curvePointRepository = curvePointRepository;
    }

    /**
     * Save a new CurvePoint
     */
    public CurvePoint save(CurvePoint curvePoint) {
        return curvePointRepository.save(curvePoint);
    }


    /**
     * Find a specific CurvePoint by Id
     */
    public CurvePoint find(int id) {
        return curvePointRepository.findById(id);
    }

    /**
     * List all CurvePoint
     */
    public List<CurvePoint> list() {
        return curvePointRepository.findAll();
    }

    /**
     * Delete a specific CurvePoint by Id
     */
    public void delete(int id) {
        curvePointRepository.delete(find(id));
    }
}
