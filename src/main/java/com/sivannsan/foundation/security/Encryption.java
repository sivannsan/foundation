package com.sivannsan.foundation.security;

import com.sivannsan.foundation.annotation.Nonnull;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SuppressWarnings("unused")
public final class Encryption {
    private Encryption() {
    }

    /**
     * Encrypts the provided string using the specified algorithm
     * @param   original the original string
     * @param   algorithm the algorithm to use; e.g. MD5, SHA-1, or SHA-256
     * @return  the encrypted string
     */
    @Nonnull
    public static String encrypt(@Nonnull String original, @Nonnull String algorithm) {
        byte[] bytes;
        try {
            bytes = MessageDigest.getInstance(algorithm).digest(original.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e); // this should never be thrown
        }
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                builder.append('0');
            }
            builder.append(hex);
        }
        return builder.toString();
    }
}
