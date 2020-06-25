package com.example.core.user.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;



public class JwtUtil {

    public static String sign(String userId, String phoneNum) {
        String tokenSecret = UUID.randomUUID().toString().replaceAll("-", "");
        try {
            Algorithm algorithm = Algorithm.HMAC256(tokenSecret);
            Map<String, Object> header = new HashMap<>(2);
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            return JWT.create()
                    .withExpiresAt(new Date())
                    .withHeader(header)
                    .withClaim("userId", userId)
                    .withClaim("phoneNum",phoneNum)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getPermission(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("permission").asInt();
        }catch (JWTDecodeException e){
            return -1;
        }
    }

    public static String getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asString();
        }catch (JWTDecodeException e){
            return null;
        }
    }


}
