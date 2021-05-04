package com.nnk.springboot.integrations;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.services.TradeService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
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
        Assert.assertEquals("Trade Account", trade.getAccount());

        // Update
        trade.setAccount("Trade Account Update");
        trade = tradeService.save(trade);
        Assert.assertEquals("Trade Account Update", trade.getAccount());

        // Find
        List<Trade> listResult = tradeService.list();
        Assert.assertTrue(listResult.size() > 0);

        // Delete
        int id = trade.getId();
        tradeService.delete(id);
        Trade tradeList = tradeService.find(id);
        Assert.assertNull(tradeList);
    }
}
