package com.wonjoolee.playhttp;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApacheHttpComponentTest {
    private static final String BASE_URL = "http://httpbin.org/";
    private ApacheHttpComponent apacheHttpComponent;

    @Before
    public void before() {
        this.apacheHttpComponent = new ApacheHttpComponent();
    }

    @Test
    public void get() throws Exception {
        CloseableHttpResponse response = apacheHttpComponent.get(BASE_URL + "/ip");
        HttpEntity httpEntity = response.getEntity();
        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(response.getStatusLine().getProtocolVersion());
        System.out.println(response.getStatusLine().getReasonPhrase());
        for (Header header : response.getAllHeaders()) {
            System.out.println(header.toString());
        }
        System.out.println(EntityUtils.toString(httpEntity));

        response.close();
    }

}