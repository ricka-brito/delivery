package com.delivery.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class PasswordUtil {

    public static String hash(String pass) throws NoSuchAlgorithmException{

        // Create MessageDigest instance for MD5
        MessageDigest md = MessageDigest.getInstance("MD5");

        // Add password bytes to digest
        md.update(pass.getBytes());

        // Get the hash's bytes
        byte[] bytes = md.digest();

        // These bytes[] has bytes in decimal format. Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
        }

        // Get complete hashed password in hex format

        return sb.toString();

    }

    public static Boolean authenticate(String pass, String hashPass) throws NoSuchAlgorithmException {
            return Objects.equals(hash(pass), hashPass);
    }
}
