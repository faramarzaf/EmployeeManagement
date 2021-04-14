package com.spring.web.app.EmployeeManagementWebApp;

import com.spring.web.app.EmployeeManagementWebApp.controller.EmployeeController;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(EmployeeController.class)
public class ServiceTest {

    /*
    @Test
      void testGetEmployeeById() {
        Employee employee = employeeController.get(1L);
        assertEquals(1l, employee.getId().longValue());
    }
*/

/*
    @Test
      void greetingShouldReturnMessageFromService() throws Exception {
        when(mainController.login()).thenReturn("login");
        this.mockMvc.perform(get("/login"))
                .andDo(print())
                .andExpect(status().isOk());
    }*/


}
