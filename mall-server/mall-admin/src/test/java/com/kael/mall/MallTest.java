package com.kael.mall;

import com.kael.mall.common.entity.UserDetails;
import com.kael.mall.common.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {AdminApplication.class})
@RunWith(SpringRunner.class)
public class MallTest {

    @Test
    public void jwtTest() {
        UserDetails userDetails = new UserDetails();
        userDetails.setUsername("admin");
        userDetails.setPassword("123456");
        String token = JwtUtil.generateToken(userDetails);
        System.out.println(token);
    }

    @Test
    public void parseJwtTest() {
        Claims claims = JwtUtil.parseToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU5NjMzNzMxMX0.PgEWnfFHxIihbjfk3RDm9OyP-7ZUEJppS9gk2aVJ8bboJ_R_-vHL8WgwMdGLKys8rqdAjuqo59e-z0kdRdL2Zw");
        String subject = claims.getSubject();
        System.out.println(subject);
    }
}
