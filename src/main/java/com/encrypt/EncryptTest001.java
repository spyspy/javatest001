package com.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;


public class EncryptTest001 {
    public static String decrypt( String key, String text ) throws Exception {
        byte [] results = decrypt( key.getBytes(), new BASE64Decoder().decodeBuffer( text ) );
        return new String( results );
    }

    public static String encrypt( String key, String text ) throws Exception {
        byte[] results = encrypt( key.getBytes(), text.getBytes() );
        return new BASE64Encoder().encode( results );
    }

    public static byte[] encrypt( byte[] key, byte[] msg ) throws Exception {
        if ( key.length != 16 ) {
            throw new IllegalArgumentException( "Key length should be 16." );
        }
        SecretKeySpec spec = new SecretKeySpec( key, "AES" );
        IvParameterSpec ivSpec = new IvParameterSpec( key );
        Cipher cipher = Cipher.getInstance( "AES/CBC/PKCS5Padding" );
        cipher.init( Cipher.ENCRYPT_MODE, spec, ivSpec );
        return cipher.doFinal( msg );
    }

    public static byte[] decrypt( byte[] key, byte[] msg ) throws Exception {
        if ( key.length != 16 ) {
            throw new IllegalArgumentException( "Key length should be 16." );
        }
        SecretKeySpec spec = new SecretKeySpec( key, "AES" );
        Cipher cipher = Cipher.getInstance( "AES/CBC/PKCS5Padding" );
        IvParameterSpec ivSpec = new IvParameterSpec( key );
        cipher.init( Cipher.DECRYPT_MODE, spec, ivSpec );
        return cipher.doFinal( msg );
    }

    public static void main( String[] args ) throws Exception {
        String msg = "This is so easy.";

        System.out.println( "原字串: " + msg );
        System.out.println( "加密後: " + encrypt( "vegafish12345678" , msg ) );
        System.out.println( "解密後: " + decrypt( "vegafish12345678", encrypt( "vegafish12345678" , msg ) ) );
    }

}

