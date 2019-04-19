package com.wonjoolee.playhttp;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequestWithBody;
import org.json.JSONObject;

import java.util.Map;

public class PlayUnirest {
    public HttpResponse<JsonNode> get(String url) throws UnirestException {
        GetRequest request = Unirest.get(url);
        System.out.println(request.getUrl());
        HttpResponse<JsonNode> jsonResponse = request.asJson();
        return jsonResponse;
    }

    public HttpResponse<JsonNode> getWithQueries(String url, Map<String, String> queries) throws UnirestException {
        GetRequest request = Unirest.get(url);
        for (Map.Entry<String, String> query : queries.entrySet()) {
            request.queryString(query.getKey(), query.getValue());
        }

        System.out.println(request.getUrl());
        HttpResponse<JsonNode> jsonResponse = request.asJson();
        return jsonResponse;
    }

    public HttpResponse<JsonNode> post(String url, JSONObject body) throws  UnirestException {
        HttpRequestWithBody request = Unirest.post(url);
        HttpResponse<JsonNode> jsonResponse = request.body(body).asJson();
        return jsonResponse;
    }
}
