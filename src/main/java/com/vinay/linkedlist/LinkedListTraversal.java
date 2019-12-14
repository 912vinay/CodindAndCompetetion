package com.vinay.linkedlist;

public class LinkedListTraversal {

    public static void main(String[] args) {

        Node head=null;
        int ar[]={1,2,3,4,5};

        for(int i=ar.length-1;i>=0;i--)
        {
            head=CreatLinkedListutil.addFirst(head ,ar[i]);
        }

        CreatLinkedListutil.printNode(head);
        System.out.println();

        Node head2=null;
        int ar2[]={12,23,33,4,5};

        for(int i=ar2.length-1;i>=0;i--)
        {
            head2=CreatLinkedListutil.addFirst(head2 ,ar2[i]);
        }

        CreatLinkedListutil.printNode(head2);
        System.out.println();
        System.out.println(CreatLinkedListutil.mergedPoint(head,head2).data);
    }
}
