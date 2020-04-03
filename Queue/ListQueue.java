package Queue;

public class ListQueue {
    private int size = 0;

    Node head;

    Node rare;

    public ListQueue() {
        head = rare = new Node();
    }

    public static void main(String[] args) {
            //测试
        ListQueue l = new ListQueue();
        l.enQueue(1);
        l.enQueue(2);
        l.enQueue(3);
        l.enQueue(4);
        l.deQueue();
        System.out.println(l.peek());

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return getSize() == 0;
    }

    //入队列
    public void enQueue(int data){
        Node newNode = new Node(data);
        rare.next = newNode;
        rare = newNode;
        size++;
    }

    //出队列
    public int deQueue(){
        if (isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        else{
            Node destroy = head.next;
            int data = destroy.getData();
            head.next = head.next.next;
            destroy = null;
            return data;
        }
    }

    //取队头元素
    public int peek(){
        if (isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        else{
            return head.next.getData();
        }
    }
}

class Node{
    private int data;
    Node next = null;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
