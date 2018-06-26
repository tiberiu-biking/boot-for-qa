package com.tpo.bootforqa.rest.client.resttemplate;

import com.tpo.bootforqa.rest.client.RestClientApplication;
import com.tpo.bootforqa.rest.client.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RestClientApplication.class)
@TestPropertySource(properties = "rest.url=https://jsonplaceholder.typicode.com/")
class RestTemplateUserRestClientTest {

    @Autowired
    private UserRestClient userRestClient;

    @Test
    void shouldFindAllUsers() {
        List<User> users = userRestClient.getAllUsers();
        users.forEach(user -> log.info(user.toString()));
    }

    @Test
    void shouldGetInfoAboutAUserById() {
        User user = userRestClient.getUserById("1");
        log.info(user.toString());
    }

    @Test
    void shouldCreateANewUser() {
        User user = new User();
        user.setName("tibi");
        User newUser = userRestClient.createUser(user);
        log.info(newUser.toString());
    }
}