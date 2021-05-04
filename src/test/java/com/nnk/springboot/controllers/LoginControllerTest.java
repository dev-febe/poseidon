package com.nnk.springboot.controllers;

import com.nnk.springboot.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class)
@AutoConfigureMockMvc(addFilters = false)
public class LoginControllerTest {
    @MockBean
    UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testShowHome() throws Exception {
        mockMvc.perform(get("/app/login"))
                .andExpect(status().isOk());
    }

    @Test
    public void testShowSecureArticleDetails() throws Exception {
        mockMvc.perform(get("/app/secure/article-details"))
                .andExpect(status().isOk());
    }

    @Test
    public void testShowError() throws Exception {
        mockMvc.perform(get("/app/error"))
                .andExpect(status().isOk());
    }
}
