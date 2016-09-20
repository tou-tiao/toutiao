package com.my;

import com.google.gson.Gson;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2016/9/3.
 */
public class GsonTest {
    int a[] = {1, 2, 3};
    @Test
    public void testGson(){
        Gson gson = new Gson();
        System.out.println(gson.toJson(a));


    }

}
