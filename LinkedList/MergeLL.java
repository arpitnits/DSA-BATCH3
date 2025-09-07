package LinkedList;

public class MergeLL {

    static LL.Node mergeTwoLists(LL.Node l1, LL.Node l2) {
        LL.Node head = null;

        //Edge cases
        if(l1==null) return l2;
        if(l2==null) return l1;

        // To assign head node
        if(l1.data<=l2.data) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        LL.Node curr = head;
        // compare and attach
        while(l1!=null && l2!=null) {
            if(l1.data<=l2.data) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // attach remaining linkedList
        if(l1!=null) {
            curr.next = l1;
        }

        // attach remaining linkedList
        if(l2!=null) {
            curr.next = l2;
        }

        return head;
    }
}
