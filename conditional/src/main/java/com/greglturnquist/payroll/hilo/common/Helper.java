package com.greglturnquist.payroll.hilo.common;

import com.google.gson.Gson;
import com.greglturnquist.payroll.hilo.json.Response;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class Helper {

    public static String getToken(String json) {
        String result = null;
        Gson gson = new Gson();
        Response foo = new Response();

        foo = gson.fromJson(json, foo.getClass());

        return foo.getData().getToken().getAccessToken();
    }

    public static String getDataString(Map<String, Integer> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Map.Entry<String, Integer> entry : params.entrySet()){
            if (first)
                first = false;
            else
                result.append("&");
                result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                result.append("=");
                result.append(entry.getValue());
        }
        return result.toString();
    }

}
