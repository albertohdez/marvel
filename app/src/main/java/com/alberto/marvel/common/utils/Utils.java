package com.alberto.marvel.common.utils;

import android.util.Log;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.alberto.marvel.common.constants.Constants.PRIVATE_KEY;
import static com.alberto.marvel.common.constants.Constants.PUBLIC_KEY;

public class Utils {
    /**
     * Builds the required API "hash" parameter (timeStamp + privateKey + publicKey)
     *
     * @param timeStamp Current timeStamp
     * @return MD5 hash string
     */
    public static String buildMd5AuthParameter(long timeStamp) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest((timeStamp + PRIVATE_KEY + PUBLIC_KEY).getBytes());
            BigInteger number = new BigInteger(1, messageDigest);

            String md5 = number.toString(16);
            while (md5.length() < 32) {
                md5 = 0 + md5;
            }
            return md5;

        } catch (NoSuchAlgorithmException e) {
            Log.e("DataManager", "Error hashing required parameters: " + e.getMessage());
            return "";
        }
    }
}
