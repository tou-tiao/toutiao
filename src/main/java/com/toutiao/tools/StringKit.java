package com.toutiao.tools;

/**
 *  judge if a string is empty or null
 */
public class StringKit {
    public static boolean isBlank(String str){
        if(null == str || str.equals("")){
            return true;
        }
        return false;
    }
}
