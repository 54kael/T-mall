package com.kael.mall.common.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 拦截器白名单
 */
public class IgnoreUrlConfig {
    private List<String> urls;

    public IgnoreUrlConfig() {
        ArrayList<String> urls = new ArrayList<>();
        urls.add("/swagger-ui.html");
        urls.add("/swagger-resources/**");
        urls.add("/swagger/**");
        urls.add("/**/v2/api-docs");
        urls.add("/**/*.js");
        urls.add("/**/*.css");
        urls.add("/**/*.png");
        urls.add("/**/*.ico");
        urls.add("/webjars/springfox-swagger-ui/**");
        urls.add("/actuator/**");
        urls.add("/druid/**");
        urls.add("/admin/login");
        urls.add("/admin/register");
        urls.add("/admin/info");
        urls.add("/admin/logout");
        urls.add("/minio/upload");
        urls.add("/error");
        urls.add("/");
        urls.add("/csrf");
        this.urls=urls;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
