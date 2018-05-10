package com.concurrent;

public class ConcurrentMain {
    public static void main(String[] args){
        Concurrent001 con = new Concurrent001();



        for(int i=0;i<=300;i++){
            con.myMethod();
            con.myMethod2();
        }
    }
}
