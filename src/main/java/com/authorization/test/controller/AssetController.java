package com.authorization.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AssetController {

    private static final String TRACE_ID = "x_trace_id";

    private static final String CLIENT_ID = "x_client_id";

    private static final String AUTHORIZATION = "Authorization";


    @PostMapping(value = "/v1/assets/{id}")
    public String postAsset(@PathVariable("id") String id,
                            @RequestHeader(CLIENT_ID) String clientId,
                            @RequestHeader(TRACE_ID) String traceId,
                            @RequestHeader(AUTHORIZATION) String token) {
        return "Document created with id: " + id;
    }


    @DeleteMapping(value = "/v1/assets/delete/{id}")
    public String deleteAsset(@PathVariable("id") String id,
                              @RequestHeader(CLIENT_ID) String clientId,
                              @RequestHeader(TRACE_ID) String traceId,
                              @RequestHeader(AUTHORIZATION) String token) {
        return "Deleted document for id: " + id;
    }

    @GetMapping(value = "v1/assets/get")
    public String getAsset(@RequestHeader(CLIENT_ID) String clientId,
                           @RequestHeader(TRACE_ID) String traceId,
                           @RequestHeader(AUTHORIZATION) String token) {
        return "adsad";
    }
}
