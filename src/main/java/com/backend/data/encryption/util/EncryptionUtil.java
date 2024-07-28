package com.backend.data.encryption.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class EncryptionUtil {

    private static final String ALGORITHM = "AES";
    private static final SecretKey SECRET_KEY = null;

    private static SecretKey generateKey(){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            keyGenerator.init(128);
            return keyGenerator.generateKey();
        }
        catch (Exception e){
            throw new RuntimeException("Error generating key encryption", e);
        }
    }

    public static String encrypt(final String data){
        try{
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, SECRET_KEY);
            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        }
        catch (Exception e){
            throw new RuntimeException("Error encrypting data", e);
        }
    }
    public static String decrypt(final String encryptedData){
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, SECRET_KEY);
            byte[] decodedtBytes = Base64.getDecoder().decode(encryptedData);
            byte[] decryptedtBytes = cipher.doFinal(decodedtBytes);
            return new String(decryptedtBytes);
        }
        catch (Exception e){
            throw new RuntimeException("Error decrypting data", e);
        }
    }

}
