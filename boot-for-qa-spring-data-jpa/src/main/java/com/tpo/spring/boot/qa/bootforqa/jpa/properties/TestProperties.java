package com.tpo.spring.boot.qa.bootforqa.jpa.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Tiberiu Popa
 * @since 6/12/2018
 */
@Getter
@Setter
@ConfigurationProperties("test")
@Component
@Validated
public class TestProperties {

    @NotNull
    private boolean enabled;

    @NotEmpty
    private String url;
}
