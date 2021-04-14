package com.spring.web.app.EmployeeManagementWebApp;

import com.spring.web.app.EmployeeManagementWebApp.controller.MainController;
import com.spring.web.app.EmployeeManagementWebApp.repository.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MainController.class)
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testLoginEndPoint() throws Exception {
        mockMvc.perform(get("/login")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }


}
