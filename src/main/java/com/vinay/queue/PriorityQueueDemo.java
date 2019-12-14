package com.vinay.queue;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        priorityQueue.add(10);
        priorityQueue.add(25);
        priorityQueue.add(-10);
        priorityQueue.add(100);
        priorityQueue.stream().forEach(e->System.out.println(e));
        Integer poll = priorityQueue.poll();
        System.out.println(poll);

         poll = priorityQueue.poll();
        System.out.println(poll);
         poll = priorityQueue.poll();
        System.out.println(poll);

        poll = priorityQueue.poll();
        System.out.println(poll);


    }
}
