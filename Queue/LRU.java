package Queue;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    int capacity;
    Node head, tail;
    Map<Integer, Node> cacheMap;

    static class Node {
        int key;
        int value;
        Node prev = null;
        Node next = null;

        Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    LRU(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        head = null;
        tail = null;
    }

    public void put(int key, int value) {
        //Key exist in cache
        if(cacheMap.containsKey(key)) {
            Node newNode = cacheMap.get(key);
            newNode.value = value;
            moveToHead(newNode);
        } else {
            //capacity is reached
            if(cacheMap.size() >= capacity) {
                removeTail();
            }
            Node newNode = new Node(key, value);
            cacheMap.put(key, newNode);
            addToHead(newNode);
        }
    }

    public int get(int key) {
        if(!cacheMap.containsKey(key)) return -1; //No such key exist

        Node newNode = cacheMap.get(key);
        moveToHead(newNode);
        return newNode.value;
    }

    private void moveToHead(Node temp) {
        if(temp==head)  return;
        if(temp==tail)  tail = tail.prev;

        //break linkage
        if(temp.prev!=null) temp.prev.next = temp.next;
        if(temp.next!=null) temp.next.prev = temp.prev;
        addToHead(temp);
    }

    private void addToHead(Node temp) {
        if(head==null) head=tail=temp; //If No node exist in LL

        temp.next = head;
        head.prev = temp;
        head = temp;
    }

    private void removeTail() {
        if(tail.prev!=null) tail.prev.next = null; //If head and tail are not equal
        else head = null;

        cacheMap.remove(tail.key);
        tail = tail.prev;
    }
}
