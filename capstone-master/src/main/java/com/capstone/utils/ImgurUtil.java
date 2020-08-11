package com.capstone.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImgurUtil {
    private final String CLIENT_ID = "88a647a2c4cd6c0";
    private final String CLIENT_SECRET = "8dfa6c8247fb797fff5583e2d14ec4eac2047337";
    private final String REFRESH_TOKEN = "6428e7e460b12d100a5fa13b3c3444a6423ac379";

    private final String URL_GET_ACCESS_TOKEN = "https://api.imgur.com/oauth2/token";
    private final String URL_UPLOAD_IMAGE = "https://api.imgur.com/3/upload";

    private String getAccessToken() {
        try {
            HttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost(URL_GET_ACCESS_TOKEN);

            // Request parameters and other properties.
            List<NameValuePair> params = new ArrayList<NameValuePair>(2);
            params.add(new BasicNameValuePair("client_id", CLIENT_ID));
            params.add(new BasicNameValuePair("client_secret", CLIENT_SECRET));
            params.add(new BasicNameValuePair("refresh_token", REFRESH_TOKEN));
            params.add(new BasicNameValuePair("grant_type", "refresh_token"));
            httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

            // Execute and get the response.
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String jsonStr = EntityUtils.toString(entity);
                JSONObject obj = new JSONObject(jsonStr);
                return obj.getString("access_token");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String uploadImage(MultipartFile file) {
        String token = getAccessToken();
        try {
            HttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost(URL_UPLOAD_IMAGE);

            // Request parameters and other properties.
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addBinaryBody("image", file.getInputStream(), ContentType.APPLICATION_OCTET_STREAM, file.getName());
            httppost.setEntity(builder.build());
            httppost.setHeader("Authorization", "Bearer " + token);

            // Execute and get the response.
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String jsonStr = EntityUtils.toString(entity);
                JSONObject obj = new JSONObject(jsonStr);
                return obj.getJSONObject("data").getString("link");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}