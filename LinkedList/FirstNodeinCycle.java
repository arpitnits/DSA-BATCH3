package LinkedList;

public class FirstNodeinCycle {

    public LL.Node cycle(LL.Node head) {
        LL.Node slow = head, fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast)  return slow;
        }
        return null;
    }

    public int cycleStart(LL.Node head) {
        LL.Node pos = cycle(head);
        if(pos==null)   return -1; //no cycle

        LL.Node entry = head; //cover l1
        //pos will cover nc-l2
        while(entry != pos) {
            entry = entry.next;
            pos = pos.next;
        }

        return entry.data;
    }
}
