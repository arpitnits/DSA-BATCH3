package LinkedList;

public class FlattenLL {

    class Node {
        int data;
        Node next;
        Node bottom;

        Node(int x) {
            data = x;
            next = null;
            bottom = null;
        }
    }

    static Node mergeByBottom(Node l1, Node l2) {
        Node head = null;

        //Edge cases
        if(l1==null) return l2;
        if(l2==null) return l1;

        // To assign head node
        if(l1.data<=l2.data) {
            head = l1;
            l1 = l1.bottom;
        } else {
            head = l2;
            l2 = l2.bottom;
        }

        Node curr = head;
        // compare and attach
        while(l1!=null && l2!=null) {
            if(l1.data<=l2.data) {
                curr.bottom = l1;
                l1 = l1.bottom;
            } else {
                curr.bottom = l2;
                l2 = l2.bottom;
            }
            curr = curr.bottom;
        }

        // attach remaining linkedList
        if(l1!=null) {
            curr.bottom = l1;
        }

        // attach remaining linkedList
        if(l2!=null) {
            curr.bottom = l2;
        }

        return head;
    }


    //TC = O(N*K)
    public Node flatten(Node head) {
        Node flattenHead = null;
        Node curr = head;

        while(curr!=null) {
            flattenHead = mergeByBottom(flattenHead, curr);
            curr = curr.next;
        }
        return head;
    }

    //TC = O(N*logK)
    public Node flattenMergeSort(Node head) {
        //Split into 2 halves
        Node mid = findMiddleRevamp(head);
        Node secondHalfHead = mid.next;
        mid.next = null;

        // Recursively flatten both halves
        Node left = flattenMergeSort(head);
        Node right = flattenMergeSort(secondHalfHead);

        //Merge both halves
        return mergeByBottom(left, right);
    }

    public static Node findMiddleRevamp(Node head) {
        Node slow = head, fast = head;
        while(fast!=null && fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
