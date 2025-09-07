package LinkedList;

public class hasCycle {

    public boolean hasCycle(LL.Node head) {
        LL.Node slow = head, fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast)  return true;
        }
        return false;
    }
}
