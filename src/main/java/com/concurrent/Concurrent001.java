package com.concurrent;

public class Concurrent001 {

    private int count  =  10;
    private Object o = new Object();

    public void myMethod(){
        synchronized (o){
            count--;
            System.out.println(Thread.currentThread().getName()+" count ="+count);
        }
    }

    private int count2 = 10;
    public void myMethod2(){
        count2--;
        System.out.println(Thread.currentThread().getName()+" count2 ="+count2);
    }
}
