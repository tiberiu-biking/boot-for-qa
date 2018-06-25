package com.tpo.spring.boot.qa.bootforqa;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
    @Tag("slow")
    void shouldNotRunTestIfAssumptionsAreNotTrue() {
        assumeTrue("NOT-WIRECARD".equals(System.getenv("USERDOMAIN")));
        Assertions.assertEquals(true, false, "This will never run!");
    }

    @RepeatedTest(3)
    @DisplayName("This is a repeated test")
    void shouldRepeatTheTest3Times() {
        log.info("Repeat");
    }

    @Test
    void shouldGroupTheAssertions() {
        // In a grouped assertion all assertions are executed
        // Any failures will be reported together.
        assertAll("person",
                () -> assertEquals("John", "Not John"),
                () -> assertEquals("Doe", "Doe"),
                () -> assertEquals("John Doe", "Not John Doe"));
    }

}
