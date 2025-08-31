package LinkedList;

public class Kth_Node {

    static LL.Node kthNode(LL.Node head, int k) {
        LL.Node curr = head;
        int counter=0;
        while(curr!= null && counter<k) { //Iterate k time or till LinkedList is not empty
            curr = curr.next;
            counter++;
        }
        return curr;
    }
}
