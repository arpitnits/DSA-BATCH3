package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class RandomPointerClone {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //TC=O(N)
    //SC=O(N)
    public Node cloneLLWithRandom(Node head) {
        Map<Node, Node> copyMap = new HashMap<>(); //<OriginalNode, ClonedNode>
        Node head1 = new Node(head.val);
        copyMap.put(head, head1);

        Node originalCurr = head.next;
        Node cloneCurr = head1;

        //Clone with next pointer
        while(originalCurr!= null) {
            Node temp = new Node(originalCurr.val);
            cloneCurr.next = temp;

            //store the copy
            copyMap.put(originalCurr, temp);

            originalCurr = originalCurr.next;
            cloneCurr = cloneCurr.next;
        }

        //Update random pointer
        originalCurr = head;
        while(originalCurr!=null) {
            /*
            originalCurr = n1
            copyMap.get(originalCurr) = n1'

            //left
            n1'.random =

            n1.random = n3
            copy.get(n3) = n3'

            n1'.random = n3'
             */
            copyMap.get(originalCurr).random = copyMap.get(originalCurr.random);
            originalCurr = originalCurr.next;
        }

        return head1;
    }


    public Node cloneLLWithoutMap(Node head) {
        Node curr = head;

        //Insert copies in between
        while(curr!=null) {
            Node nxt = curr.next; //original next

            Node temp = new Node(curr.val);//create a temp cloned node
            temp.next = curr.next; //n1'--> n2
            curr.next = temp; //n1--> n1'

            //move to next node
            curr = nxt;
        }

        //Update random pointer for cloned nodes
        curr = head;
        while (curr!=null) {
            /*
            n1.next ==> n1'
            n1'.random

            n1.random = n2
            n2.next = n2'

            right side = cloned copy of original random node
            left side = clone copy of original node
             */
            if(curr.random!=null)   curr.next.random = curr.random.next;

            curr = curr.next.next; //Going to next original value
        }

        //Clear the mess for placing nodes in-between
        Node head1 = head.next;
        Node originalCurr = head, clonedCurr = head1;

        while(clonedCurr.next != null) {
            /*
            n1.next = n1'
            n1.next = n2

            n1.next --> n2
             */
            originalCurr.next = originalCurr.next.next;
            clonedCurr.next = clonedCurr.next.next;

            originalCurr = originalCurr.next; //n2
            clonedCurr = clonedCurr.next; //n2'
        }
        originalCurr.next = null;

        return head1;
    }
}














