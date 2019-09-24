package kz.webdogovor.config.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();
        String targetUrl = "";

        switch (role) {
            case "[SUPERUSER]":
                targetUrl = "/superuser/dashboard";
                break;
            case "[OPERATOR]":
                targetUrl = "/operator/dashboard";
                break;
            case "[USER]":
                targetUrl = "/user/dashboard";
                break;
        }
        return targetUrl;
    }
}
