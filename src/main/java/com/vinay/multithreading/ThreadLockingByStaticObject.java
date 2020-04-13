package com.vinay.multithreading;

public class ThreadLockingByStaticObject implements Runnable {

    MyLock myLock;

    public ThreadLockingByStaticObject(MyLock myLock) {
        this.myLock = myLock;
    }

    @Override
    public void run() {

        synchronized (myLock) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " ");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
