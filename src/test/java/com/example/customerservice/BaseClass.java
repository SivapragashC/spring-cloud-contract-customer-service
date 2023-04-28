package com.example.customerservice;


import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = CustomerServiceApplication.class)
@ExtendWith(SpringExtension.class)
public class BaseClass {

  @Autowired
  private CustomerRestController customerRestController;

  @MockBean
  private CustomerRepository customerRepository;

  @BeforeEach
  public void before() {
    Mockito.when(customerRepository.findAll())
        .thenReturn(Arrays.asList(new Customer(1L,"Tommy"), new Customer(2L, "Jerry")));
    RestAssuredMockMvc.standaloneSetup(this.customerRestController);
  }
}
