package com.kael.mall.common.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kael.mall.common.api.Result;
import com.kael.mall.common.api.Statue;
import com.kael.mall.common.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("访问路径: {}",request.getRequestURI());
        String username;
        String authHeader = request.getHeader("Authorization");
        if (authHeader==null) {
            log.info("authHeader为空");
            return result(response);
        } else {
            username = JwtUtil.getUserNameFormToken(authHeader);
            if (username==null) {
                return result(response);
            }
        }
        request.setAttribute("username",username);
        return true;
    }

    /**
     * token验证失败
     * @param response 返回json数据
     * @return
     */
    private boolean result(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            ObjectMapper om = new ObjectMapper();
            String s = om.writeValueAsString(Result.failure(Statue.UNAUTHORIZED));
            PrintWriter out = response.getWriter();
            out.println(s);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
