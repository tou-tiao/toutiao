package com.fzu.tools;

/**
 *  judge if Java8 string is empty or null
 */
public class StringKit {
    public static boolean isBlank(String str){
        if(null == str || str.equals("")){
            return true;
        }
        return false;
    }
}
