package com.spring.web.app.EmployeeManagementWebApp.service;

import com.spring.web.app.EmployeeManagementWebApp.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;


public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployeeById(long id);

    Long deleteEmployeeById(long id);

    Boolean existsEmployeeByEmail(String email);

    Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
