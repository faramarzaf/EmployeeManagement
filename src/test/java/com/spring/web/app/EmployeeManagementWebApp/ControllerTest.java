package com.spring.web.app.EmployeeManagementWebApp;

import com.spring.web.app.EmployeeManagementWebApp.controller.EmployeeController;
import com.spring.web.app.EmployeeManagementWebApp.controller.MainController;
import com.spring.web.app.EmployeeManagementWebApp.controller.UserRegistrationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


@SpringBootTest
class ControllerTest {

    @Autowired
    private MainController mainController;

    @Autowired
    private EmployeeController employeeController;

    @Autowired
    private UserRegistrationController userRegistrationController;

    @Test
    void test_controllers() {
        assertAll(
                () ->   assertThat(mainController).isNotNull(),
                () ->   assertThat(employeeController).isNotNull(),
                () ->   assertThat(userRegistrationController).isNotNull()
        );
    }


}
