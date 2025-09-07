package LinkedList;

public class MiddleOfLL {

    //4 --> 2
    public LL.Node middleNode(LL.Node head) {
        LL.Node slow = head, fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
