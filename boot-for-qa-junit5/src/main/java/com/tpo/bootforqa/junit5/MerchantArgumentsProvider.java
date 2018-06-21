package com.tpo.bootforqa.junit5;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

/**
 * @author Tiberiu Popa
 * @since 6/21/2018
 */
public class MerchantArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(new Merchant(1), new Transaction("C1")),
                Arguments.of(new Merchant(2), new Transaction("C2")));
    }
}
