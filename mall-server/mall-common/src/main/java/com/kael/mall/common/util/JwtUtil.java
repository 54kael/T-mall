package com.kael.mall.common.util;

import com.kael.mall.common.api.Statue;
import com.kael.mall.common.entity.UserDetails;
import com.kael.mall.common.exception.MallException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Jwt生成与解析
 */
public class JwtUtil {


    /**
     * 生成token
     */
    public static String generateToken(UserDetails userDetails) {
        Map<String,Object> claims = new HashMap<>();
        claims.put("sub",userDetails.getUsername());
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
                .signWith(SignatureAlgorithm.HS512, "kael")
                .compact();
    }


    /**
     * 解析token
     */
    public static Claims parseToken(String token) {
        Claims claims = null;
        try {
            claims=Jwts.parser()
                    .setSigningKey("kael")
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new MallException(Statue.UNAUTHORIZED);
        }
        return claims;
    }

    /**
     * 从token获取用户名
     */
    public static String getUserNameFormToken(String token) {
        String username;
        try {
            Claims claims = parseToken(token);
            username=claims.getSubject();
        } catch (MallException e) {
            username = null;
        }
        return username;
    }
}
