package com.tpo.spring.boot.qa.bootforqa.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Tiberiu Popa
 * @since 6/12/2018
 */
@Getter
@Setter
@ConfigurationProperties("test")
@Component
public class TestProperties {

    private boolean enabled;
    private String  url;
}
