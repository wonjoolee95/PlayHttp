package com.wonjoolee.playhttp;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class PlayUnirestTest {
    private static final String BASE_URL = "http://httpbin.org/";
    private PlayUnirest unirest;

    @Before
    public void before() {
        this.unirest = new PlayUnirest();
    }

    @Test
    public void get() throws UnirestException {
        HttpResponse<JsonNode> response = unirest.get(BASE_URL + "ip");
        JSONObject jsonObject = response.getBody().getObject();
        String origin = jsonObject.getString("origin");
        System.out.println(origin);
        System.out.println(response.getHeaders());
        System.out.println(response.getStatus());
    }

    @Test
    public void post() throws UnirestException {
        JSONObject body = new JSONObject();
        body.put("foo", "bar");

        HttpResponse<JsonNode> jsonResponse = unirest.post(BASE_URL + "post", body);
        JSONObject jsonObject = jsonResponse.getBody().getObject();
        System.out.println(jsonObject);
    }

}