package com.tpo.bootforqa.lombok;

import org.junit.jupiter.api.Test;

class BuilderMerchantTest {

    @Test
    void testBuilder() {
        BuilderMerchant.builder()
                       .id(1)
                       .name("Wirecard Merchant")
                       .build();
    }
}