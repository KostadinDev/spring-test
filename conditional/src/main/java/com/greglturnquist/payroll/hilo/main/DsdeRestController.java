package com.greglturnquist.payroll.hilo.main;

import com.greglturnquist.payroll.Employee;
import com.greglturnquist.payroll.hilo.common.Constants;
import com.greglturnquist.payroll.hilo.connector.FunctionCaller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RestController

public class DsdeRestController {






        // Aggregate root

        @GetMapping("/functions")
        String  startfunction1(@RequestParam Integer operation, Integer
                deviceIds) {
            Map<String, Integer> formParams  = new HashMap<String, Integer>() {{
                put("operation", operation);
                put("deviceIds", deviceIds);
            }};
            FunctionCaller functionCaller=new FunctionCaller();

            String result= null;
            try {
                result = functionCaller.callAnyDSDEFunction(Constants.TASK,formParams, Constants.CONTENTTYPEFORM);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }


            System.out.println("result2 = " + result);
            return result;
        }

        @PostMapping("/functions")
        String startfunction(@RequestBody String something) {
            return "something";
        }



}
