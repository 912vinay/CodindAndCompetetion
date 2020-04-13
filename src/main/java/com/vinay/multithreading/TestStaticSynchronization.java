package com.vinay.multithreading;

public class TestStaticSynchronization {


    public static void main(String[] args) throws InterruptedException {
        MyLock myLock = new MyLock();
        Thread t1 = new Thread(new ThreadLockingByStaticObject(myLock));
        t1.start();


        Thread t2 = new Thread(new ThreadLockingByStaticObject(new MyLock()));
        t2.start();

    }
}
