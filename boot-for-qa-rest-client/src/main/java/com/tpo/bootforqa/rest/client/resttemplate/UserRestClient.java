package com.tpo.bootforqa.rest.client.resttemplate;

import com.tpo.bootforqa.rest.client.domain.User;

import java.util.List;

/**
 * @author Tiberiu Popa
 * @since 6/12/2018
 */
public interface UserRestClient {

    //https://jsonplaceholder.typicode.com/
    List<User> getAllUsers();

    User createUser(User user);

    User getUserById(String userId);
}