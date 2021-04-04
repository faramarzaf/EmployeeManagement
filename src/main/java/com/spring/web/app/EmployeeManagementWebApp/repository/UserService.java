package com.spring.web.app.EmployeeManagementWebApp.repository;


import com.spring.web.app.EmployeeManagementWebApp.dto.UserRegistrationDto;
import com.spring.web.app.EmployeeManagementWebApp.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);

    Boolean existsUserByEmail(String email);


}
