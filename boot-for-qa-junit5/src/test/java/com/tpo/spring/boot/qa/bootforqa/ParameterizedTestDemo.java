package com.tpo.spring.boot.qa.bootforqa;

import com.tpo.bootforqa.junit5.Merchant;
import com.tpo.bootforqa.junit5.MerchantArgumentsProvider;
import com.tpo.bootforqa.junit5.Slow;
import com.tpo.bootforqa.junit5.TestType;
import com.tpo.bootforqa.junit5.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * @author Tiberiu Popa
 * @since 6/13/2018
 */
@Slf4j
class ParameterizedTestDemo {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void demoValueSource(int argument) {
        log.info("Argument: {}", argument);
    }

    @ParameterizedTest
    @EnumSource(TestType.class)
    void demoEnumSource(TestType argument) {
        log.info("Argument: {}", argument);
    }

    @ParameterizedTest
    @MethodSource("createTestMerchants")
    void demoMethodSource(Merchant merchant) {
        log.info("Running the test for merchant: {}", merchant);
    }

    @ParameterizedTest
    @MethodSource("createTestMerchantsAndTransactions")
    void demoMethodSourceWithArguments(Merchant merchant, Transaction transaction) {
        log.info("Running the test for merchant {} with transaction {}", merchant, transaction);
    }

    @ParameterizedTest
    @ArgumentsSource(MerchantArgumentsProvider.class)
    void demoArgumentsSourceWithArguments(Merchant merchant, Transaction transaction) {
        log.info("Running the test for merchant {} with transaction {}", merchant, transaction);
    }

    @CsvSource({"test1, 1", "test2, 2", "test3, 3"})
    @ParameterizedTest(name = "{index} ==> first=''{0}'', second={1}")
    @Slow
    void demoParameterizedTest(String name, String index) {
        log.info("First parameter: {}. Second parameter: {}", name, index);
    }

    @ValueSource(strings = {"test1", "test2"})
    @ParameterizedTest
    void demoAssumptions(String candidate) {
        assumeTrue("test1".equalsIgnoreCase(candidate));
        log.info(candidate);
    }

    private static Stream<Merchant> createTestMerchants() {
        return Stream.of(new Merchant(1), new Merchant(2));
    }

    private static Stream<Arguments> createTestMerchantsAndTransactions() {
        return Stream.of(
                Arguments.of(new Merchant(1), new Transaction("C1")),
                Arguments.of(new Merchant(2), new Transaction("C2")));
    }
}
