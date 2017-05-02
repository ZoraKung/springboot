package com.zora.kung.config;

/**
 * Created by Walter on 2016/11/22.
 */
public final class ConfigConstants {

    public final static String MYBATIS_MAPPER_SCAN_PACKAGE_PRIMARY = "com.zora.kung.biz.**.mapper";

    public final static String MYBATIS_MAPPER_SCAN_PACKAGE_SECONDARY = "com.wjxinfo.othersys.**.mapper";

    public final static String MYBATIS_MAPPER_LOCATION_PRIMARY = "classpath:mybatis/primary/**/*.xml";

    public final static String MYBATIS_MAPPER_LOCATION_SECONDARY = "classpath:mybatis/secondary/**/*.xml";

    public final static String[][] SHIRO_FILTER_MAP = {
            {"/login", "authc"},
            {"/logout", "logout"},
            {"/WEB-INF/static/**", "anon"},
            {"/api/**", "anon"},
            {"/favicon.ico", "anon"},
            {"/register/**", "anon"},
            {"/admin/**", "roles[R001]"},
            {"/user/profile", "authc"},
            {"/**", "user"}
    };

    public final static String SHIRO_LOGIN_URL = "/login";
    public final static String SHIRO_SUCCESS_URL = "/";
    public final static String SHIRO_CACHE_FILE = "classpath:ehcache/ehcache-shiro.xml";

}
