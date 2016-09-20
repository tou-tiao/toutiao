package com.toutiao;


import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;


public class jsonTest {

    @Test
    public void jsonToString(){
        // method1
        try {
            JSONObject jsonObject = new JSONObject().put("记者","12");
            System.out.println(jsonObject.toString());
        }catch (JSONException e){
            e.printStackTrace();
        }



        // method2

    }

    @Test void stringToJson(){
        // method1

        // method2
    }
}
