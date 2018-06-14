package com.tpo.bootforqa.rest.client.retrofit;

import com.tpo.bootforqa.rest.client.domain.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

/**
 * @author Tiberiu Popa
 * @since 6/12/2018
 */
public interface UserRestClient {

    //https://jsonplaceholder.typicode.com/
    @GET("users")
    Call<List<User>> getAllUsers();

    @POST("users")
    Call<User> createUser(@Body User user);

    @GET("users/{userId}")
    Call<User> getUserById(@Path("userId") String userId);

}