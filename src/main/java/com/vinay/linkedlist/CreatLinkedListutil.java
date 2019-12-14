package com.vinay.linkedlist;

public class CreatLinkedListutil {

    public static Node addFirst(Node head, int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        return head;
    }

    public static Node mergedPoint(Node head1, Node head2) {
        if (head1 == null || head2 == null)
            return null;

        if (head1.data == head2.data)
            return head1;
        Node node=null;
        if (head1.next != null) {
             node= mergedPoint(head1.next, head2);
        }

        if (node != null) {
            return node;
        } else if (head2.next != null) {
            return mergedPoint(head1, head2.next);
        }
        return null;
    }

    public static void printNode(Node head) {
        while (head != null) {
            if (head.next != null)
                System.out.print(head.data + "->");
            else
                System.out.print(head.data);
            head = head.next;

        }

    }
}
