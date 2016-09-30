package com.fzu;


import org.junit.Test;

import java.io.IOException;

import static com.fzu.tools.EncryptUtils.md5;
import static com.fzu.tools.EncryptUtils.sha;

public class EncryptUtilsTest {

    @Test
    public static void main(String[] args) throws IOException {
        String user = "111111";
        System.out.println("原始字符串 " + user);
        System.out.println("MD5加密 " + md5(user));
        System.out.println("SHA加密 " + sha(user));
    }
}
