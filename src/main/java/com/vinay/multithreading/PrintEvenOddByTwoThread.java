package com.vinay.multithreading;

public class PrintEvenOddByTwoThread {


    public static void main(String[] args) throws InterruptedException {
        Flag i = new Flag();
        i.setEven(true);
        OddThread oddThread = new OddThread(i);
        EvenThread evenThread = new EvenThread(i);
        new Thread(evenThread).start();
        Thread.sleep(1000);
        new Thread(oddThread).start();


    }
}

class Flag {
    boolean isEven;

    public boolean isEven() {
        return isEven;
    }

    public void setEven(boolean even) {
        isEven = even;
    }
}

class EvenThread implements Runnable {

    Flag flag;

    public EvenThread(Flag oddThread) {
        this.flag = oddThread;
    }

    @Override
    public void run() {

        synchronized (flag) {
            for (int i = 0; i < 100; i = i + 2) {


                if (!flag.isEven) {
                    try {
                        flag.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                System.out.print(" " + i);
                flag.setEven(false);
                flag.notify();

            }
        }

    }
}

class OddThread implements Runnable {

    Flag flag;

    public OddThread(Flag i) {
        this.flag = i;
    }

    @Override
    public void run() {

        synchronized (flag) {
            for (int i = 1; i < 100; i = i + 2) {

                if (flag.isEven) {
                    try {
                        flag.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(" " + i);
                flag.setEven(true);
                flag.notify();
            }

        }
    }

}
