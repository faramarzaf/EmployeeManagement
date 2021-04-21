package com.spring.web.app.EmployeeManagementWebApp.repository;

import com.spring.web.app.EmployeeManagementWebApp.model.Employee;
import com.spring.web.app.EmployeeManagementWebApp.service.EmployeeService;
import com.spring.web.app.EmployeeManagementWebApp.service.EmployeeServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EmployeeRepositoryTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @AfterEach
    void teardown() {
        repository.deleteAll();
    }

    @Test
    void employee_exists_by_email() {

        Employee employee = new Employee(
                "Sara",
                "pits",
                "spits@gmail.com"
        );
        repository.save(employee);
        Boolean exists = repository.existsEmployeeByEmail("spits@gmail.com");
        assertThat(exists).isTrue();
    }

/*    @Test
    void whenSaved_thenFindsByName() {
        userRepository.save(new UserEntity(
                "Zaphod Beeblebrox",
                "zaphod@galaxy.net"));
        assertThat(userRepository.findByName("Zaphod Beeblebrox")).isNotNull();
    }*/


    @Test
    void delete_employee_by_id() {
/*        long id = 10;
        given(repository.existsById(id)).willReturn(true);
         verify(repository).deleteById(id);*/

        long doseId = 42;

        employeeService.deleteEmployeeById(doseId);
        // verify the mocks
        verify(repository, times(1)).deleteById(eq(doseId));
    }


    @Test
    public void deleteTest() throws Exception {
        // given
        final Employee entity = new Employee(1L,"Sara","pits","spits@gmail.com");

        Mockito.when(repository.findById(1L)).thenReturn(java.util.Optional.of(entity));

        // when
        final Long result = employeeService.deleteEmployeeById(1L);

        // then
        Mockito.verify(repository, times(1))
                .delete(entity);

        Mockito.when(repository.findById(1L)).thenReturn(java.util.Optional.of(entity)).thenReturn(null);
    }

}
