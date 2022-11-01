package com.authorization.test.util;

import lombok.extern.slf4j.Slf4j;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.Map;

@Slf4j
@Component
public class TokenDecoder {
    public static String getTokenDecoded() {
        KeycloakAuthenticationToken authentication = (KeycloakAuthenticationToken)
                SecurityContextHolder.getContext().getAuthentication();
        Principal principal = (Principal) authentication.getPrincipal();
        String profile_id = "";
        if (principal instanceof KeycloakPrincipal) {
            KeycloakPrincipal kPrincipal = (KeycloakPrincipal) principal;
            AccessToken token = kPrincipal.getKeycloakSecurityContext().getToken();
            Map<String, Object> customClaims = token.getOtherClaims();
            if (customClaims.containsKey("profile_id")) {
                profile_id = String.valueOf(customClaims.get("profile_id"));
            }
        }
        return profile_id;
    }
}
