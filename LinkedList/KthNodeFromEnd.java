package LinkedList;

public class KthNodeFromEnd {

    static LL.Node getKthNodeFromLast(LL.Node head, int k) {
        LL.Node slow = head, fast = head;
        int counter=1;


        //Fast pointer will move k distance from start
        while(fast!= null && counter<=k) {
            fast = fast.next;
            counter++;
        }

        //Now slow and fast will move remaining N-K+1 distance
        while (fast!=null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
