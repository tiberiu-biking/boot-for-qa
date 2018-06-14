package com.tpo.bootforqa.rest.client.resttemplate;

import com.tpo.bootforqa.rest.client.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author Tiberiu Popa
 * @since 6/14/2018
 */
@Service
public class RestTemplateUserRestClient implements UserRestClient {

    private static final String       USERS_URL = "https://jsonplaceholder.typicode.com/users";
    private static final String       USER_URL  = "https://jsonplaceholder.typicode.com/users/{userId}";
    private final        RestTemplate restTemplate;

    @Autowired
    public RestTemplateUserRestClient(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    @Override
    public List<User> getAllUsers() {
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(USERS_URL, User[].class);
        return Arrays.asList(responseEntity.getBody());
    }

    @Override
    public User createUser(User user) {
        ResponseEntity<User> responseEntity = restTemplate.postForEntity(USERS_URL, user, User.class);
        return responseEntity.getBody();
    }

    @Override
    public User getUserById(String userId) {
        ResponseEntity<User> responseEntity = restTemplate.getForEntity(USER_URL, User.class, userId);
        return responseEntity.getBody();
    }
}
