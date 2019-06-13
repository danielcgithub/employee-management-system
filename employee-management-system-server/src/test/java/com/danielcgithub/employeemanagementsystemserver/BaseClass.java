package com.danielcgithub.employeemanagementsystemserver;

import com.danielcgithub.employeemanagementsystemserver.controller.EmployeeController;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

/**
 * BaseClass
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmployeeManagementSystemServerApplication.class)
@AutoConfigureWireMock(port = 9002)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class BaseClass {

    @Autowired
    EmployeeController employeeController;

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(employeeController);
    }

}