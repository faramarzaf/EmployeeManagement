package com.spring.web.app.EmployeeManagementWebApp.repository;


import com.spring.web.app.EmployeeManagementWebApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Long deleteEmployeeById(Long bookId);

    Boolean existsEmployeeByEmail(String email);

    Employee findEmployeeByEmail(String email);

}
