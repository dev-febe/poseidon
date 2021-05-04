package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.services.TradeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(TradeController.class)
@AutoConfigureMockMvc(addFilters = false)
public class TradeControllerTest {
    @MockBean
    TradeService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testShow() throws Exception {
        mockMvc.perform(get("/trade/list"))
                .andExpect(status().isOk());
    }

    @Test
    public void testShowAddForm() throws Exception {
        mockMvc.perform(get("/trade/add"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSubmitAddForm() throws Exception {
        mockMvc.perform(post("/trade/add"))
                .andExpect(status().isOk());
    }

    @Test
    public void testShowUpdateForm() throws Exception {
        Mockito.when(service.find(1)).thenReturn(new Trade());
        mockMvc.perform(get("/trade/update/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSubmitUpdateForm() throws Exception {
        mockMvc.perform(post("/trade/update/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        Mockito.when(service.find(1)).thenReturn(new Trade());
        mockMvc.perform(get("/trade/delete/1"))
                .andExpect(status().is3xxRedirection());
    }
}
