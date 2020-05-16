package com.greglturnquist.payroll.hilo.connector;

import com.greglturnquist.payroll.hilo.common.Constants;
import com.greglturnquist.payroll.hilo.common.Helper;
import com.greglturnquist.payroll.hilo.common.TokenReceiver;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class FunctionCaller {

    public String callAnyDSDEFunction(String functionRoute, Map <String, Integer> params, String contentType)throws UnsupportedEncodingException {
        String token= TokenReceiver.getToken();
        String paramsString= Helper.getDataString(params);
        NetClient netClient=new NetClient();
        String result = netClient.callpost(Constants.BASEURL2 + functionRoute, paramsString, token,contentType);
        return result;
    }

    public String callFunctionJson(String functionRoute, String params, String contentType)throws UnsupportedEncodingException {
        String token= TokenReceiver.getToken();

        NetClient netClient=new NetClient();
        String result = netClient.callpost(Constants.BASEURL + functionRoute, params, token,contentType);
        return result;
    }
}
