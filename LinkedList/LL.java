package LinkedList;

import static LinkedList.Operations.*;

public class LL {

    public static class Node {
        int data;
        Node next = null;

        //Empty Data
        Node() {
        }

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node head = null;

        Node node1 = new Node(5);
        head = node1;

        Node node2 = new Node(3);
        node1.next = node2;

        Node node3 = new Node(8);
        node2.next = node3;

        Node node4 = new Node(2);
        node3.next = node4;

        printIterative(head);

        Node updatedHeadValue = reverse(head);

        printIterative(updatedHeadValue);
    }
}
