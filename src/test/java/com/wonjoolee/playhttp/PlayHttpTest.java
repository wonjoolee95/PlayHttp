package com.wonjoolee.playhttp;

import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayHttpTest {
    private static final String BASE_URL = "http://httpbin.org/";
    private static final String PROTOCOL = "protocol";
    private static final String CODE = "code";
    private static final String URL = "url";

    private PlayHttp playHttp;

    @Before
    public  void beforeClass() {
        playHttp = new PlayHttp();
    }

    @Test
    public void get() throws Exception {
        PlayHttp.ResponseObject responseObject = playHttp.get(BASE_URL + "ip");
        System.out.println(responseObject.responseBody);
        System.out.println(responseObject.response.code());
        System.out.println(responseObject.response.protocol());
        System.out.println(responseObject.response.headers());
    }

    @Test
    public void getWithQueries() throws Exception {
    }

    @Test
    public void post() throws Exception {
    }

}