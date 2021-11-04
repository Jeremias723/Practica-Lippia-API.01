package services;

import com.crowdar.api.rest.MethodsService;


public class BaseService extends MethodsService {

    public static final ThreadLocal<String> ID_TIME = new ThreadLocal<String>();
    public static final ThreadLocal<String> API_KEY = new ThreadLocal<String>();
    public static final ThreadLocal<String> ID_WORKSPACE = new ThreadLocal<String>();
    public static final ThreadLocal<String> TIME = new ThreadLocal<String>();
    public static final ThreadLocal<String> ID_PROJECT = new ThreadLocal<String>();
    public static final ThreadLocal<String> ID_USER = new ThreadLocal<String>();
    public static final ThreadLocal<String> DESCRIPTION = new ThreadLocal<String>();
    public static final ThreadLocal<String> HOUR = new ThreadLocal<String>();

}
