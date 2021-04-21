package com.spring.web.app.EmployeeManagementWebApp;

import com.spring.web.app.EmployeeManagementWebApp.model.Employee;
import com.spring.web.app.EmployeeManagementWebApp.repository.EmployeeRepository;
import com.spring.web.app.EmployeeManagementWebApp.service.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DataJpaTest
@SpringBootTest
public class EmployeeServiceTest {


    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;


    @Before
    public void init() {
        employeeService = new EmployeeServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void save_employee() {
        Employee emp = new Employee(1L, "Sam", "McDon", "Sammcd@gmail.com");
        employeeService.saveEmployee(emp);
        verify(employeeRepository, times(1)).save(emp);

    }

    @Test
    public void get_employee_by_id() {
        when(
                employeeRepository.findById(1L)
        ).thenReturn(java.util.Optional.of(new Employee(1L, "Sam", "McDon", "Sammcd@gmail.com")));

        Employee employee = employeeService.getEmployeeById(1L);

        assertEquals(1L, employee.getId());
        assertEquals("Sam", employee.getFirstName());
        assertEquals("McDon", employee.getLastName());
        assertEquals("Sammcd@gmail.com", employee.getEmail());
    }

    @Test
    public void get_employee_by_email() {
        when(
                employeeRepository.findEmployeeByEmail("Sammcd@gmail.com")
        ).thenReturn((new Employee(1L, "Sam", "McDon", "Sammcd@gmail.com")));

        Employee employee = employeeService.findEmployeeByEmail("Sammcd@gmail.com");

        assertEquals(1L, employee.getId());
        assertEquals("Sam", employee.getFirstName());
        assertEquals("McDon", employee.getLastName());
        assertEquals("Sammcd@gmail.com", employee.getEmail());
    }


    @Test
    public void test_find_all_employees() {

        List<Employee> list = new ArrayList<>();
        Employee empOne = new Employee(1L, "John", "Woods", "John@gmail.com");
        Employee empTwo = new Employee(2L, "Samuel", "Mit", "Samuel@gmail.com");
        Employee empThree = new Employee(3L, "Johnson", "Qua", "Johnson@gmail.com");

        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);

        when(employeeRepository.findAll()).thenReturn(list);

        List<Employee> empList = employeeService.getAllEmployees();

        assertEquals(3, empList.size());
        verify(employeeRepository, times(1)).findAll();

    }

    @Test
    public void delete_employee() {
        Employee employee = new Employee(5L, "sam", "mira", "sam@gmail.com");
        employeeRepository.deleteById(employee.getId());
        Employee deletedEmployee = employeeRepository.findEmployeeByEmail("sam@gmail.com");
        assertThat(deletedEmployee).isNull();
    }

    @Test
    public void update_employee() {
        // TODO
    }

}
