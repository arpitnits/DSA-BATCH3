package LinkedList;

import static LinkedList.Operations.reverse;

public class AddTwoNumbers {


    //803 + 202 = 1005

    static LL.Node addTwoNumber(LL.Node l1, LL.Node l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;

        //Reverse both LL
        l1 = reverse(l1);
        l2 = reverse(l2);

        LL.Node curr = null, head=null;

        int sum=0, carry=0, val=0;

        while(l1 != null && l2!=null) {
            sum = l1.data + l2.data + carry;
            val = sum%10;
            carry = sum/10;
            LL.Node temp = new LL.Node(val);

            if(head==null) {
                head = temp;
                curr = head;
            } else {
                curr.next = temp;
                curr = curr.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1!=null) {
            sum = l1.data + carry;
            val = sum/10;
            carry = sum%10;
            curr.next = new LL.Node(val);
            l1 = l1.next;
            curr = curr.next;
        }

        while(l2!=null) {
            sum = l2.data + carry;
            val = sum/10;
            carry = sum%10;
            curr.next = new LL.Node(val);
            l2 = l2.next;
            curr = curr.next;
        }

        if(carry!=0) {
            curr.next = new LL.Node(carry);
        }

        return reverse(head);
    }


}
