package com.spring.web.app.EmployeeManagementWebApp.repository;


import com.spring.web.app.EmployeeManagementWebApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    Boolean existsUserByEmail(String email);

}
