package com.wonjoolee.playhttp;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

public class PlayHttp {
    private static final OkHttpClient client = new OkHttpClient();
    private String responseBody;

    static class ResponseObject {
        Response response;
        String responseBody;
        public ResponseObject(Response response, String responseBody) {
            this.response = response;
            this.responseBody = responseBody;
        }
    }

    public ResponseObject get(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);

        try (Response response = call.execute()) {
            ResponseObject responseObject = new ResponseObject(
                    response, response.body().string());
            return responseObject;
        }
    }

    public Response getWithQueries(String url, Map<String, String> parameters) throws IOException {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
        for (Map.Entry<String, String> parameter : parameters.entrySet()) {
            urlBuilder.addQueryParameter(parameter.getKey(), parameter.getValue());
        }

        Request request = new Request.Builder().url(urlBuilder.toString()).build();
        Call call = client.newCall(request);

        try (Response response = call.execute()) {
            return response;
        }
    }

    public Response post(String url, Map<String, String> parameters) throws IOException {
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        for (Map.Entry<String, String> parameter : parameters.entrySet()) {
            bodyBuilder.add(parameter.getKey(), parameter.getValue());
        }

        Request request = new Request.Builder().url(url).post(bodyBuilder.build()).build();
        Call call = client.newCall(request);

        try (Response response = call.execute()) {
            return response;
        }
    }

    public String getResponseBody() {
        return responseBody;
    }
}
