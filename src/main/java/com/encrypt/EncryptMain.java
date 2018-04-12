package com.encrypt;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EncryptMain {
    public static void main(String[] args) throws NoSuchPaddingException, IOException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        String test = EncryptTest002.encrypt02("test");
        System.out.println("加密:" + test);


        String test2 = EncryptTest002.decrypt02(test);
        System.out.println("解密:" + test2);

        //test
    }
}
