package com.cpe.springboot.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {

    public static String hashPassword(String pass) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashPassword = digest.digest(pass.getBytes(StandardCharsets.UTF_8));
        return new String(hashPassword);
    }
}
