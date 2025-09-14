package Queue;

public class Implementation {

    static class ArrayImplementation {
        int[] arr;
        int capacity;
        int queueSize;

        int front = 0, rear = -1;

        ArrayImplementation(int c) {
            this.capacity = c;
            this.queueSize = 0;
            arr = new int[this.capacity];
        }

        //Insert At Rear
        public void enQueue(int x) {
            if(queueSize == capacity) {
                System.out.println("Queue is Full");
                return;
            }

            rear = (rear+1)%capacity;
            arr[rear] = x;
            queueSize++;
        }

        //Removal from front
        public int deQueue() {
            if(queueSize==0) {
                System.out.println("Queue is Empty");
                return -1;
            }

            int x = arr[front];
            front = (front+1)%capacity;
            queueSize--;
            return x;
        }

        public int front() {
            if(queueSize==0) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];
        }

        public int rear() {
            if(queueSize==0) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[rear];
        }
    }

    public static void main(String[] args) {
        ArrayImplementation arrayImplementation = new ArrayImplementation(3);

        arrayImplementation.enQueue(512);
        arrayImplementation.enQueue(72);
        arrayImplementation.enQueue(3124);
        System.out.println(arrayImplementation.front());
        System.out.println(arrayImplementation.rear());

        arrayImplementation.enQueue(2124);
        System.out.println(arrayImplementation.front());
        System.out.println(arrayImplementation.rear());


        arrayImplementation.deQueue();
        System.out.println(arrayImplementation.front());
        System.out.println(arrayImplementation.rear());
    }
}
