package com.danielcgithub.employeemanagementsystemserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.danielcgithub.employeemanagementsystemserver.model.Employee;
import com.github.tomakehurst.wiremock.client.WireMock;

import org.assertj.core.api.BDDAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWireMock(port = 9000)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmployeeManagementSystemServerApplicationTests {

	@Rule
	public StubRunnerRule stubRunnerRule = new StubRunnerRule()
			.downloadStub("com.danielcgithub", "employee-management-system-server").withPort(9003);

	@Test
	public void test_should_return_all_employees() {
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/api/v1/employees"))
				.willReturn(WireMock.aResponse().withStatus(200)));

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List> responseEntity = restTemplate.getForEntity("http://localhost:9000/api/v1/employees",
				List.class);
		BDDAssertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	public void test_should_return_all_employees_stub() {

		RestTemplate restTemplate = new RestTemplate();

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);

		ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("http://localhost:9003/api/v1/employees",
				Object[].class);
		BDDAssertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}

}
