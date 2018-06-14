package com.tpo.bootforqa.rest.client.retrofit;

import com.tpo.bootforqa.rest.client.RestClientApplication;
import com.tpo.bootforqa.rest.client.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RestClientApplication.class)
class RetrofitUserRestClientTest {

    @Autowired
    private UserRestClient userRestClient;

    @Test
    void shouldFindAllUsers() throws IOException {
        Call<List<User>> result = userRestClient.getAllUsers();
        Response<List<User>> response = result.execute();
        List<User> users = response.body();
        users.forEach(user -> log.info(user.toString()));
    }


    @Test
    void shouldGetInfoAboutAUserById() throws IOException {
        Call<User> result = userRestClient.getUserById("1");
        Response<User> response = result.execute();
        log.info(response.toString());
        User user = response.body();
        log.info(user.toString());
    }

    @Test
    void shouldCreateANewUser() throws IOException {
        User user = new User();
        user.setName("tibi");
        User newUser = userRestClient.createUser(user).execute().body();
        log.info(newUser.toString());
    }

}