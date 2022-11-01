package com.authorization.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.keycloak.AuthorizationContext;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Slf4j
@RestController
@RequestMapping(value = "/v1/logistics", produces = MediaType.APPLICATION_JSON_VALUE)
public class LogisticsController {

//    @GetMapping(value = "/get")
//    public AuthorizationContext getLogistics(HttpServletRequest request) {
//        KeycloakSecurityContext keycloakSecurityContext = (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
//        AuthorizationContext authorizationContext = keycloakSecurityContext.getAuthorizationContext();
//        return authorizationContext;
//    }

    @GetMapping(value = "/get")
    public String getLogistics(Principal principal) {
       return principal.getName();
    }

    @PostMapping(value = "/post")
    public String postLogistics() {
        return "POST";
    }

    @PutMapping(value = "/put")
    public String putLogistics() {
        return "PUT";
    }

    @DeleteMapping(value = "/delete")
    public String delete() {
        return "DELETE";
    }

    @PatchMapping(value = "/patch")
    public String patch(){
        return "PATCh";
    }

    @GetMapping(value = "/sellerServiceability/get")
    public String getSellerServiceability(){
        return "GET sellerServiceability";
    }

    @PostMapping(value = "/sellerServiceability/post")
    public String postSellerServiceability(){

        return "POST sellerServiceability";
    }


}
