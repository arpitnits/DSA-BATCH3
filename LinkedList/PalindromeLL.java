package LinkedList;

import static LinkedList.Operations.reverse;

public class PalindromeLL {

    public LL.Node findMiddle(LL.Node head) {
        LL.Node slow = head, fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome(LL.Node head) {
        LL.Node mid = findMiddle(head);
        LL.Node firstHalf = head;
        LL.Node secondHalf = reverse(mid);

        while(firstHalf!=mid) {
            if(firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }
}


