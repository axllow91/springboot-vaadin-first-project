package com.mrn.firstproject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ComplexService {
    private String postsURL = "https://jsonplaceholder.typicode.com/posts";
    private OkHttpClient okHttpClient = new OkHttpClient();
    private Response response;

    public JSONArray getData() throws IOException {
        Request request = new Request.Builder().
                                    url(postsURL).build();

        response = okHttpClient.newCall(request).execute();

        try {
            return new JSONArray(response.body().string());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
