package com.authorization.test.controller;

import com.authorization.test.util.TokenDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/v1/profile",produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileController {

    private static final String TRACE_ID = "x_trace_id";

    private static final String CLIENT_ID = "x_client_id";

    private static final String AUTHORIZATION = "Authorization";

    @PostMapping(value = "/{id}")
    public String createProfile(@PathVariable("id") String id,
                                @RequestHeader(TRACE_ID) String traceId,
                                @RequestHeader(CLIENT_ID) String clientId,
                                @RequestHeader(AUTHORIZATION) String jwt) {
        if(TokenDecoder.getTokenDecoded().equals(id)){
            return "Profile Id matched POC completed profileId: " + id;
        }
        else {
            return "Profile Id did not match";
        }
    }
}
