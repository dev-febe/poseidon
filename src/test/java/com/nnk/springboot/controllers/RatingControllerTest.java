package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.services.RatingService;
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
@WebMvcTest(RatingController.class)
@AutoConfigureMockMvc(addFilters = false)
public class RatingControllerTest {
    @MockBean
    RatingService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testShow() throws Exception {
        mockMvc.perform(get("/rating/list"))
                .andExpect(status().isOk());
    }

    @Test
    public void testShowAddForm() throws Exception {
        mockMvc.perform(get("/rating/add"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSubmitAddForm() throws Exception {
        mockMvc.perform(post("/rating/add"))
                .andExpect(status().isOk());
    }

    @Test
    public void testShowUpdateForm() throws Exception {
        Mockito.when(service.find(1)).thenReturn(new Rating());
        mockMvc.perform(get("/rating/update/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSubmitUpdateForm() throws Exception {
        mockMvc.perform(post("/rating/update/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        Mockito.when(service.find(1)).thenReturn(new Rating());
        mockMvc.perform(get("/rating/delete/1"))
                .andExpect(status().is3xxRedirection());
    }
}
