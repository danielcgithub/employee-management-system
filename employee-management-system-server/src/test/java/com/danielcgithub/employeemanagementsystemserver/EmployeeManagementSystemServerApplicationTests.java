package com.danielcgithub.employeemanagementsystemserver;

import java.util.List;

import com.github.tomakehurst.wiremock.client.WireMock;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWireMock(port = 9000)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmployeeManagementSystemServerApplicationTests {

	@Test
	public void test_should_return_all_employees() {
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/api/v1/employees"))
				.willReturn(WireMock.aResponse().withStatus(201)));

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List> responseEntity = restTemplate.getForEntity("http://localhost:9000/api/v1/employees",
				List.class);
		BDDAssertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
	}

}
