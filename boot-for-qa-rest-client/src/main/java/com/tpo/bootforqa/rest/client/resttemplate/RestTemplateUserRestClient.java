package com.tpo.bootforqa.rest.client.resttemplate;

import com.tpo.bootforqa.rest.client.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tiberiu Popa
 * @since 6/14/2018
 */
@Slf4j
@Service
public class RestTemplateUserRestClient implements UserRestClient {

    @Value("${rest.url}")
    private String restUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public RestTemplateUserRestClient(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    @Override
    public List<User> getAllUsers() {
        URI usersURI = UriComponentsBuilder.fromHttpUrl(restUrl)
                                           .path("users")
                                           .build()
                                           .toUri();

        log.info("URI: {}", usersURI);
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(usersURI, User[].class);

        return Arrays.asList(responseEntity.getBody());
    }

    @Override
    public User createUser(User user) {
        URI usersURI = UriComponentsBuilder.fromUriString(restUrl)
                                           .path("users")
                                           .build()
                                           .toUri();

        log.info("URI: {}", usersURI);
        ResponseEntity<User> responseEntity = restTemplate.postForEntity(usersURI, user, User.class);

        return responseEntity.getBody();
    }

    @Override
    public User getUserById(String userId) {
        URI userURI = UriComponentsBuilder.fromUriString(restUrl)
                                          .path("users")
                                          .pathSegment(userId)
                                          .build()
                                          .toUri();
        log.info("URI: {}", userURI);
        ResponseEntity<User> responseEntity = restTemplate.getForEntity(userURI, User.class);

        return responseEntity.getBody();
    }
}
