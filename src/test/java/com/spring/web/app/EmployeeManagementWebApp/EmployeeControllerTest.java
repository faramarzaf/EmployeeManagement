package com.spring.web.app.EmployeeManagementWebApp;

import com.spring.web.app.EmployeeManagementWebApp.controller.EmployeeController;
import com.spring.web.app.EmployeeManagementWebApp.model.Employee;
import com.spring.web.app.EmployeeManagementWebApp.repository.UserService;
import com.spring.web.app.EmployeeManagementWebApp.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @MockBean
    private UserService userService;


    @Test
    void testViewHomePage() throws Exception {
        mockMvc.perform(get("/")
                .contentType("application/json"))
                .andExpect(status().is(302));
    }

    @Test
    void testShowNewEmployeeForm() throws Exception {
        mockMvc.perform(get("/showNewEmployeeForm")
                .contentType("application/json"))
                .andExpect(status().is(302));
    }

    @Test
    void testSaveEmployee() throws Exception {
        mockMvc.perform(get("/saveEmployee")
                .contentType("application/json"))
                .andExpect(status().is(302));
    }

    @Test
    void testUpdateEmployee() throws Exception {
        mockMvc.perform(get("/updateEmployee")
                .contentType("application/json"))
                .andExpect(status().is(302));
    }

    @Test
    void testShowFormForUpdate() throws Exception {
        Employee employee = new Employee("joe", "mc", "joemc@gmail.com");
        mockMvc.perform(get("/showFormForUpdate/" + employee.getId())
                .contentType("application/json"))
                .andExpect(status().is(302));
    }

    @Test
    void testDeleteEmployee() throws Exception {
        Employee employee = new Employee(10L, "joe", "mc", "joemc@gmail.com");
        mockMvc.perform(delete("/deleteEmployee/{id}", employee.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }

    @Test
    void testFindPaginated() throws Exception {
        mockMvc.perform(get("/page/{pageNo}", 1)
                .contentType("application/json"))
                .andExpect(status().is(302));
    }

}
