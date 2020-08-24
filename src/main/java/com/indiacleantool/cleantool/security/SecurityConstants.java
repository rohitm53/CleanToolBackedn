package com.indiacleantool.cleantool.security;

public class SecurityConstants {

    public static final String COMMON_USER_ENDPOINT="/api/users/**";
    public static final String STATIC_SERVICE_ENDPOINT="/api/services/**";


    //API information in wild card formats
    public static final String COMPANY_API_ENDPOINT="/api/company/**";
    public static final String MOBILE_API_ENDPOINT="/api/mobile/**";
    public static final String EMPLOYEE_API_ENDPOINT="/api/employee/**";

    //Roles
    public static final String ROLE_COMPANY="COMPANY";
    public static final String ROLE_EMPLOYEE="EMPLOYEE";
    public static final String ROLE_MOBILE_USER="MOBILE_USER";


    public static final String HEADER_STRING = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer "; //need to have spacr after Bearer
    public static final long   EXPIRATION_TIME = 30_00000;

}
