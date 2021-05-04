package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.services.BidListService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(BidListController.class)
@AutoConfigureMockMvc(addFilters = false)
public class BidListControllerTest {
    @MockBean
    BidListService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testShow() throws Exception {
        mockMvc.perform(get("/bidList/list"))
                .andExpect(status().isOk());
    }

    @Test
    public void testShowAddForm() throws Exception {
        mockMvc.perform(get("/bidList/add"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSubmitAddForm() throws Exception {
        mockMvc.perform(post("/bidList/add"))
                .andExpect(status().isOk());
    }

    @Test
    public void testShowUpdateForm() throws Exception {
        Mockito.when(service.find(1)).thenReturn(new BidList());
        mockMvc.perform(get("/bidList/update/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSubmitUpdateForm() throws Exception {
        mockMvc.perform(post("/bidList/update/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        Mockito.when(service.find(1)).thenReturn(new BidList());
        mockMvc.perform(get("/bidList/delete/1"))
                .andExpect(status().is3xxRedirection());
    }
}
