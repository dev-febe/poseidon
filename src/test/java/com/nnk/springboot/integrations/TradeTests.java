package com.nnk.springboot.integrations;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.services.TradeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TradeTests {

    @Autowired
    private TradeService tradeService;

    @Test
    public void tradeTest() {
        Trade trade = new Trade("Trade Account", "Type");

        // Save
        trade = tradeService.save(trade);
        Assert.assertNotNull(trade.getId());
        Assert.assertTrue(trade.getAccount().equals("Trade Account"));

        // Update
        trade.setAccount("Trade Account Update");
        trade = tradeService.save(trade);
        Assert.assertTrue(trade.getAccount().equals("Trade Account Update"));

        // Find
        List<Trade> listResult = tradeService.list();
        Assert.assertTrue(listResult.size() > 0);

        // Delete
        Integer id = trade.getId();
        tradeService.delete(id);
        Trade tradeList = tradeService.find(id);
        Assert.assertNull(tradeList);
    }
}
