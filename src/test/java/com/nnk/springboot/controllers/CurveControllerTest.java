package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.services.CurveService;
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
@WebMvcTest(CurveController.class)
@AutoConfigureMockMvc(addFilters = false)
public class CurveControllerTest {
    @MockBean
    CurveService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testShow() throws Exception {
        mockMvc.perform(get("/curvePoint/list"))
                .andExpect(status().isOk());
    }

    @Test
    public void testShowAddForm() throws Exception {
        mockMvc.perform(get("/curvePoint/add"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSubmitAddForm() throws Exception {
        mockMvc.perform(post("/curvePoint/add"))
                .andExpect(status().isOk());
    }

    @Test
    public void testShowUpdateForm() throws Exception {
        Mockito.when(service.find(1)).thenReturn(new CurvePoint());
        mockMvc.perform(get("/curvePoint/update/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSubmitUpdateForm() throws Exception {
        mockMvc.perform(post("/curvePoint/update/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        Mockito.when(service.find(1)).thenReturn(new CurvePoint());
        mockMvc.perform(get("/curvePoint/delete/1"))
                .andExpect(status().is3xxRedirection());
    }
}
