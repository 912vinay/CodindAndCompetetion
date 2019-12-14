package com.vinay.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> queue=new ArrayList<>();
        queue.add(12);
        queue.add(14);
        queue.add(15);
        queue.add(16);
        System.out.println(queue);
        new Thread(()->{
            int t=100;
            while (t<1000) {

                queue.add(t++);
                //System.out.println(queue);
            }

        }).start();
        Thread.sleep(200);
        while (!queue.isEmpty())
        {
            int t=queue.get(0);
            System.out.println(t);
            queue.remove(0);
        }
        System.out.println(queue.size());
    }


}
