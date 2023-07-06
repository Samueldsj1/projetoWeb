package com.senai.projetoweb.services;

import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Optional;

@Service
public class CookieService {

    public static String getCookie(HttpServletRequest request, String key) {
        return Optional.ofNullable(request.getCookies())
                .flatMap(cookies -> Arrays.stream(cookies)
                        .filter(cookie -> key.equals(cookie.getName()))
                        .findFirst()
                        .map(Cookie::getValue)
                        .map(value -> URLDecoder.decode(value, StandardCharsets.UTF_8))
                )
                .orElse(null);
    }

    public static void setCookie(HttpServletResponse response, String key, String value, int segundos) {
        Cookie cookie = new Cookie(key, URLEncoder.encode(value, StandardCharsets.UTF_8));
        cookie.setMaxAge(segundos);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static void deleteCookie(HttpServletResponse response, String key) {
        Cookie cookie = new Cookie(key, "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
