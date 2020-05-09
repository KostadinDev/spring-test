package com.greglturnquist.payroll.hilo.common;

import com.google.gson.Gson;
import com.greglturnquist.payroll.hilo.connector.NetClient;
import com.greglturnquist.payroll.hilo.json.Credential;

import static com.greglturnquist.payroll.hilo.common.Constants.CONTENTTYPEJSON;

public class TokenReceiver {
    static String username = "csedviz@hawaii.edu";
    static String password = "bambam50$";


    public static String getToken() {

        Credential credential = new Credential();
        credential.setUsername(username);
        credential.setPassword(password);
        Gson gson = new Gson();
        String json = gson.toJson(credential);
        NetClient netClient = new NetClient();
            System.out.println("url = "+Constants.BASEURL +Constants.TOKEN);
            System.out.println("json = "+json);
        String result = netClient.callpost(Constants.BASEURL + Constants.TOKEN, json, null, CONTENTTYPEJSON);
        String token = Helper.getToken(result);

        return token;
    }

}
