package LinkedList;

import static LinkedList.Operations.size;

public class IntersectionLL {

    public LL.Node getIntersectionNode(LL.Node head1, LL.Node head2) {
        int n = size(head1);
        int m = size(head2);
        int diff = Math.abs(n-m);
        if(n>m) {
            while(diff>0) {
                head1 = head1.next;
                diff--;
            }
        } else {
            while(diff>0) {
                head2 = head2.next;
                diff--;
            }
        }

        while(head1!=null && head2!=null && head1!=head2) {
            head1 = head1.next;
            head2 = head2.next;
        }

        if(head1==head2)
            return head1;
        else return null;
    }
}
