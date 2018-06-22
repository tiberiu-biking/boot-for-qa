package com.tpo.bootforqa.jsonxml.request;

import lombok.Value;

/**
 * @author Tiberiu Popa
 * @since 6/22/2018
 */
@Value
public class JsonRequest {

    private String id;
    private String merchantAccountId;
    private Amount amount;

}
