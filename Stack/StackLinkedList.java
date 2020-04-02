package Stack;

public class StackLinkedList {

    int size = 0;

    Node head = null;

    public static void main(String[] args) {
        StackLinkedList l = new StackLinkedList();
        l.push(1);
        l.push(2);
        l.push(2);
        l.push(2);
        l.push(2);
        l.pop();
        System.out.println(l.size);
    }

    public void push(int data){
        Node item = new Node(data);
        item.next = head;
        head = item;
        size++;
    }

    public int pop(){
        if (size == 0){
            throw new RuntimeException("stack is empty!");
        }
        else{
            Node destroy = head;
            head = head.next;
            int nodeData = destroy.data;
            destroy = null;
            size--;
            return nodeData;
        }
    }
}

class Node{
    int data;

    Node next = null;

    public Node(int data) {
        this.data = data;
    }
}


