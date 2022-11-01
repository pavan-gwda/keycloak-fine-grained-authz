package com.authorization.test.controller;

import com.authorization.test.util.TokenDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ReportsController {
    private static final String AUTHORIZATION = "Authorization";

    @GetMapping(value = "/reports/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getReports(@PathVariable("id") String id) {
        return new ResponseEntity<>("GET Reports API triggered", null, HttpStatus.SC_OK);
    }
    @GetMapping(value = "/report/billing/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getReportBill(@PathVariable("id") String id) {
        return new ResponseEntity<>("GET Report Billing API triggered", null, HttpStatus.SC_OK);
    }


    @PostMapping(value = "/report/billing/post/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> postReportBill(@PathVariable("id") String id) {
        return new ResponseEntity<>("POST Report Billing API triggered", null, HttpStatus.SC_OK);
    }

    @DeleteMapping("/reports/{id}")
    public ResponseEntity<Object> deleteReport(@PathVariable String id) {
        return new ResponseEntity<>("DELETE Reports API triggered", null, HttpStatus.SC_OK);
    }

    @PostMapping("/reports/post/{id}")
    public ResponseEntity<Object> createReport(@PathVariable String id){
        return new ResponseEntity<>("Post Report Billing API triggered", null, HttpStatus.SC_OK);
    }

    @PutMapping("/reports/put/{id}")
    public ResponseEntity<Object> updateReport(@PathVariable String id){
        return new ResponseEntity<>("Put Report Billing API triggered", null, HttpStatus.SC_OK);
    }



    @GetMapping("/reports/test/{id}")
    public String testApi(@PathVariable String id, @RequestHeader(AUTHORIZATION) String token){
        String profile_id = TokenDecoder.getTokenDecoded();
        log.info(profile_id);
        return "Token Decoding done";
    }
}
