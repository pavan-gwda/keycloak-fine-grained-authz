package com.authorization.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AdminController {

    @GetMapping(value = "/admin/{id}")
    public String adminTest(@PathVariable("id") String id){
        return "Admin API authorized";
    }
}
