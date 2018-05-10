package com.encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EncryptTest002 {

    public static String encryptMplus(String src) throws NoSuchAlgorithmException,NoSuchPaddingException,InvalidKeyException,IllegalBlockSizeException, BadPaddingException,UnsupportedEncodingException{
        Cipher cipher = Cipher.getInstance("AES");
        byte[] key = "1234567890123456".getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(key,"AES");
        cipher.init(Cipher.ENCRYPT_MODE,skeySpec);
        final byte[] encryptData = cipher.doFinal(src.getBytes("utf-8"));
        return URLEncoder.encode(new BASE64Encoder().encodeBuffer(encryptData),"UTF-8");
    }

    public static String decrypt(String src) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, BadPaddingException, IllegalBlockSizeException {
        byte[] key = "1234567890123456".getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(key,"AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init( Cipher.DECRYPT_MODE, skeySpec);
        final byte[] encryptData = cipher.doFinal(new BASE64Decoder().decodeBuffer( src ));
        return URLEncoder.encode(new BASE64Encoder().encodeBuffer(encryptData),"UTF-8");
    }

    public static String encrypt02(String text) throws UnsupportedEncodingException {
        byte[] results = new byte[0];
        try{
            byte[] key = "1234567890123456".getBytes();
            SecretKeySpec spec = new SecretKeySpec( key, "AES" );
            IvParameterSpec ivSpec = new IvParameterSpec( key );
            Cipher cipher = Cipher.getInstance( "AES/CBC/PKCS5Padding" );
            cipher.init( Cipher.ENCRYPT_MODE, spec, ivSpec );
            results = cipher.doFinal( text.getBytes() );
        }catch (Exception e){
            e.printStackTrace();
        }

        //return new BASE64Encoder().encode( results );
        return URLEncoder.encode(new BASE64Encoder().encodeBuffer(results),"UTF-8");
    }

    public static String decrypt02(String text) throws UnsupportedEncodingException {
        byte[] results = new byte[0];
        String rtn = "";
        try{
            byte[] key = "1234567890123456".getBytes();

            String myString = URLDecoder.decode(text,"UTF-8");

            SecretKeySpec spec = new SecretKeySpec( key, "AES" );
            Cipher cipher = Cipher.getInstance( "AES/CBC/PKCS5Padding" );
            IvParameterSpec ivSpec = new IvParameterSpec( key );
            cipher.init( Cipher.DECRYPT_MODE, spec, ivSpec );
            results =cipher.doFinal( new BASE64Decoder().decodeBuffer( myString ) );
            rtn = new String( results,"UTF-8" );
        }catch (Exception e){
            e.printStackTrace();
        }

        return rtn;
    }

}
