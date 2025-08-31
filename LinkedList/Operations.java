package LinkedList;

public class Operations {


    public static void printIterative(LL.Node head) {
        LL.Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + "-->");
            curr = curr.next; //Go to next node
        }
        System.out.println();
    }

    public static void printRecursive(LL.Node curr) {
        if(curr==null) return;

        System.out.print(curr.data + "|" + curr.next +  "-->");
        printRecursive(curr.next);
    }


    static LL.Node insertionAtBeginning(LL.Node head, int val) {
        LL.Node newNode = new LL.Node(val);
        newNode.next = head; //Step 1
        head = newNode; //Step 2
        return head;
    }

    static LL.Node insertionAtEnd(LL.Node head, int val) {
        LL.Node newNode = new LL.Node(val);
        LL.Node current = head;

        //Iterate to reach last node
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode; //update the reference of last node
        return head;
    }

    static LL.Node insertAtPosition(LL.Node head, int prevValue, int val) {

        LL.Node newNode = new LL.Node(val);

        LL.Node curr = head;
        while(curr.data != prevValue) {
            curr = curr.next;
        }
        newNode.next = curr.next; //new node start pointing to next node
        curr.next = newNode;
        return head;
    }

    static LL.Node search(LL.Node head, int key) {
        LL.Node curr = head;
        while(curr!= null || curr.data != key) {
            curr = curr.next;
        }
        return curr;
    }

    static int size(LL.Node head) {
        LL.Node curr = head;
        int size =0;
        while(curr!=null) {
            curr = curr.next;
            size++;
        }
        return size;
    }

    static LL.Node delete(LL.Node head, int key) {
        LL.Node curr = head, prev= null;
        //Key matched with first element
        if(head!=null && head.data == key) {
            head = head.next; //head = curr.next
            return head;
        }

        while(curr!= null && curr.data!= key) {
            prev = curr;
            curr = curr.next;
        }
        if(curr != null) {
            prev.next = curr.next;
        }

        return head;
    }

    static LL.Node reverse(LL.Node head) {
        LL.Node curr = head, nxt = head, prev=null;

        while (curr != null) {
            nxt = curr.next; //Store the nxt node
            curr.next = prev; //Update current reference to prev
            prev = curr;
            curr = nxt;
        }
        head = prev;
        return head; //because this will be the head
    }

    static LL.Node reverseRecursiveUtil(LL.Node curr, LL.Node prev) {
        //If you reach the prev value was the node to be returned
        if(curr==null) {
            return prev;
        }
        LL.Node nxt = curr.next;
        curr.next = prev;
        return reverseRecursiveUtil(nxt, curr);
    }

    static LL.Node reverseRecursive(LL.Node head) {
        return reverseRecursiveUtil(head, null);
    }
}
