package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.CurvePoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CurvePointRepository extends JpaRepository<CurvePoint, Integer> {
    CurvePoint save(CurvePoint curvePoint);
    CurvePoint findById(int id);
    List<CurvePoint> findAll();
    void delete(CurvePoint curvePoint);
}
