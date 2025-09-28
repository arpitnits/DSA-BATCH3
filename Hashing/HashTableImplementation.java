package Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class HashTableImplementation {

    //Use Separate Chaining for collisions
    static class HashNode<K,V> {
        K key;
        V val;

        HashNode<K,V> next = null;

        HashNode(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }


    static class Map<K,V> {
        int bucketSize, currSize;
        private ArrayList<HashNode<K,V>> bucketArray;

        Map(int bucketSize) {
            this.bucketSize = bucketSize;
            currSize = 0;

            for(int i=0;i<bucketSize;i++)
                bucketArray.add(null);
        }

        private int getBucketIndex(K key) {
            return key.hashCode() % bucketSize;
        }

        //Update node reference while removing and set new Head as bucket Index
        public void remove(K key) {

        }

        public V get(K key) {
            int bucketIndex = getBucketIndex(key);
            HashNode<K,V> head = bucketArray.get(bucketIndex);

            while(head!=null) {
                if(head.key.equals(key))    return head.val;

                head = head.next;
            }
            return null;
        }

        public void add(K key, V val) {
            int bucketIndex = getBucketIndex(key);
            HashNode<K,V> head = bucketArray.get(bucketIndex);

            //If key exist, then find node and update value
            HashNode<K,V> temp = head;
            while(temp!=null) {
                if(temp.key.equals(key)) {
                    temp.val = val;
                    return;
                }
                temp = temp.next;
            }

            //Create new Node and store
            HashNode<K,V> newNode = new HashNode<>(key, val);

            //replace head with newNode
            newNode.next = head;
            bucketArray.set(bucketIndex, newNode);
            currSize++;

            //If load factor is more than threshold, then double the size of bucket
//            if((1.0*currSize/bucketSize) > 0.7) {
//                ArrayList<HashNode<K,V>> tempArray = bucketArray;
//                bucketArray = new ArrayList<>();
//                bucketSize = 2*bucketSize;
//
//            }
        }
    }
}
