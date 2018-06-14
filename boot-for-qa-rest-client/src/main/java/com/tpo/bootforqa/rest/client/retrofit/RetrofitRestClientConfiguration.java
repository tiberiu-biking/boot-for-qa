package com.tpo.bootforqa.rest.client.retrofit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * @author Tiberiu Popa
 * @since 6/12/2018
 */
@Configuration
public class RetrofitRestClientConfiguration {

    @Bean
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    @Bean
    public UserRestClient userRestClient(Retrofit retrofit) {
        return retrofit.create(UserRestClient.class);
    }
}
