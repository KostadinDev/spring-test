package com.greglturnquist.payroll.hilo.main;



import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.greglturnquist.payroll.hilo.common.Constants;
import com.greglturnquist.payroll.hilo.connector.FunctionCaller;



public class DsdeCaller {
    //static String username="DseeLab_78H_V2_78000955";
    // static String password="82808797";
    //static String username="kostadindev";
    //static String password="DMjk2tKE";


    public static void main(String[] args) throws UnsupportedEncodingException {







        Map<String, Integer> formParams  = new HashMap<String, Integer>() {{
            put("operation", 2);
            put("deviceIds", 65157);
        }};
        FunctionCaller functionCaller=new FunctionCaller();
        String result=functionCaller.callAnyDSDEFunction(Constants.TASK,formParams, Constants.CONTENTTYPEFORM);



        System.out.println("result2 = " + result);

    }



}
