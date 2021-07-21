package com.csclib.utils;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/** MD5加密算法工具类 */
public class MD5Util {
  public static String getMD5(String password) {
    password += password + "www.caclib.com";
    password = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
    return password;
  }
}
