package com.zjy.shuati_ya.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.Map;

public class jwtUtils {
    private static final String KEY="eX0lY3xZ9PjFgS3G+KqzVr/7qp7wDq1sYjEOVxRTj8s=";
    private static final Key SECRET_KEY= Keys.hmacShaKeyFor(KEY.getBytes());

    public static String generateToken(Map<String,Object> claims){
        return Jwts.builder()
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000))
                .compact();
    }

    public static Claims parseToken(String token) throws Exception{
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
