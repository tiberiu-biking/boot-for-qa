package com.tpo.spring.boot.qa.bootforqa;

import com.tpo.bootforqa.junit5.Slow;
import com.tpo.bootforqa.junit5.TestType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * @author Tiberiu Popa
 * @since 6/13/2018
 */
@Slf4j
class JUnit5Demo {

    @Test
    @Tag(TestType.FAST)
    @Disabled
    void demoDisabledTest(String candidate) {
        log.info(candidate);
        assumeTrue("CI".equals(System.getenv("ENV")));
    }

    @RepeatedTest(3)
    @DisplayName("This is a repeated test")
    @Tag(TestType.SLOW)
    void demoRepeatedTest() {
        log.info("Repeat");
    }

    @CsvSource({"test1, 1", "test2, 2", "test3, 3"})
    @ParameterizedTest(name = "{index} ==> first=''{0}'', second={1}")
    @Slow
    void demoParameterizedTest(String name, String index) {
        log.info("First parameter: {}. Second parameter: {}", name, index);
    }

    @Test
    void demoGroupedAssertions() {
        // In a grouped assertion all assertions are executed, and any failures will be reported together.
        assertAll("person",
                () -> assertEquals("John", "Not John"),
                () -> assertEquals("Doe", "Doe"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1", "test2"})
    @Tag(TestType.SLOW)
    void demoAssumptions(String candidate) {
        assumeTrue("test1".equalsIgnoreCase(candidate));
        log.info(candidate);
    }

}
