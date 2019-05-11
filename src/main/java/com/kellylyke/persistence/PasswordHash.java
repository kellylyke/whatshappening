package com.kellylyke.persistence;

import java.security.MessageDigest;

/**
 * class for hashing passwords
 */
public class PasswordHash {

    /**
     * hashes password using sha256 with help from https://stackoverflow.com/questions/5531455/how-to-hash-some-string-with-sha256-in-java
     * @param base original password
     * @return hashed password
     */
    public static String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}