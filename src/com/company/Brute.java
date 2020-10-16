package com.company;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

public class Brute {
    public static void force(int a, int b, String hex_pas_in) throws NoSuchAlgorithmException {
        char[] symbs = new char[5];
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        long startTime = System.currentTimeMillis();
        long endTime;
        for (int i = a; i < b; i++) {
            symbs[0] = (char)i;
            for (int j = 97; j < 123; j++) {
                symbs[1] = (char)j;
                for (int k = 97; k < 123; k++){
                    symbs[2] = (char)k;
                    for (int l = 97; l < 123; l++){
                        symbs[3] = (char)l;
                        for (int z = 97; z < 123; z++){
                            symbs[4] = (char)z;
                            String gen = new String(symbs);
                            messageDigest.update(gen.getBytes(StandardCharsets.UTF_8));
                            byte[] digest = messageDigest.digest();
                            String hex = String.format("%064x", new BigInteger(1, digest));if (hex.equals(hex_pas_in)){
                                endTime = System.currentTimeMillis();
                                System.out.println(gen);
                                System.out.println(TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.MILLISECONDS) + " милисекунд");
                                System.exit(0);
                            } else {
                                messageDigest.reset();
                            }
                        }
                    }
                }
            }
        }
    }
}
