package com.tpo.spring.boot.qa.bootforqa.properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("dev")
class TestPropertiesTest {

    @Autowired
    private TestProperties testProperties;

    @Test
    public void testPropoertiesLoading() {
        Assertions.assertTrue(testProperties.isEnabled());
        Assertions.assertEquals("random:9000/url", testProperties.getUrl());
    }
}