package com.tpo.bootforqa.rest.client.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.tpo.bootforqa.rest.client.RestClientApplication;
import com.tpo.bootforqa.rest.client.domain.User;
import com.tpo.bootforqa.rest.client.resttemplate.UserRestClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

/**
 * @author Tiberiu Popa
 * @since 6/25/2018
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RestClientApplication.class)
@TestPropertySource(properties = "rest.url=http://localhost:8080")
class WiremockDemoTest {

    private static WireMockServer MOCK_SERVER;

    @Autowired
    private UserRestClient userRestClient;

    @BeforeAll
    static void beforeAll() {
        WireMockConfiguration wireMockConfiguration = WireMockConfiguration.wireMockConfig()
                                                                           .port(8080);
        MOCK_SERVER = new WireMockServer(wireMockConfiguration);
        MOCK_SERVER.start();
        log.info("Available stubbing ------------------------------");
        WireMock.listAllStubMappings();
        log.info("Available stubbing ------------------------------");
    }

    @AfterAll
    static void afterAll() {
        MOCK_SERVER.stop();
    }

    @Test
    void shouldMockGETUsers() {
        stubFor(get(urlEqualTo("/users"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("users/users.json")));

        List<User> users = userRestClient.getAllUsers();

        users.forEach(user -> log.info(user.toString()));
    }

    @Test
    void shouldMockGETUserById() {
        User firstUser = userRestClient.getUserById("1");

        log.info(firstUser.toString());
    }

}

