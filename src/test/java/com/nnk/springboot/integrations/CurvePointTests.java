package com.nnk.springboot.integrations;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.services.CurveService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurvePointTests {

    @Autowired
    private CurveService curveService;

    @Test
    public void curvePointTest() {
        CurvePoint curvePoint = new CurvePoint(10, 10d, 30d);

        // Save
        curvePoint = curveService.save(curvePoint);
        Assert.assertEquals(10, curvePoint.getCurveId());

        // Update
        curvePoint.setCurveId(20);
        curvePoint = curveService.save(curvePoint);
        Assert.assertEquals(20, curvePoint.getCurveId());

        // Find
        List<CurvePoint> listResult = curveService.list();
        Assert.assertTrue(listResult.size() > 0);

        // Delete
        int id = curvePoint.getId();
        curveService.delete(id);
        CurvePoint curvePointList = curveService.find(id);
        Assert.assertNull(curvePointList);
    }

}
