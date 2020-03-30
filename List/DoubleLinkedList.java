package DoubleList;

public class DoubleLinkedList {
    int length;

    DoubleNode head = null;

    DoubleNode tail = null;

    public static void main(String[] args) {
        DoubleLinkedList l = new DoubleLinkedList();
        l.appendElement(2);
        l.appendElement(3);
        l.appendElement(4);
        l.appendElement(5);
        l.insertNode(3,0);
        l.printList();
    }

    //尾部添加元素
    public void appendElement(int data) {
        if (head == null) {
            head = new DoubleNode(data);
            length = 1;
        } else {
            DoubleNode item = head;
            while (item.next != null) {
                item = item.next;
            }
            DoubleNode newNode = new DoubleNode(data);
            item.next = newNode;
            tail = newNode;
            tail.next = null;
            tail.prev = item;
            length++;
        }
    }

    //头部添加元素
    public void appendHead(int data) {
        if (head == null) {
            head = new DoubleNode(data);
            length = 1;
        } else {
            DoubleNode newNode = new DoubleNode(data);
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
            length++;
        }
    }

    //通过索引获取元素的值
    public void getElement(int index) {
        if (index < 1 || index > length) {
            System.out.println("索引超出范围");
        }
        else{
            int p = 1;
            DoubleNode item = head;
            while(p != index){
                item = item.next;
                p++;
            }
            System.out.println(item.data);
        }
    }

    //删除某一索引元素并返回该元素值
    public int deleteElement(int index){
        if (index < 1 || index > length){
            System.out.println("索引超出范围");
            return 0;
        }
        else if (index == 1){
            DoubleNode item = head;
            head = head.next;
            return item.data;
        }
        else if (index == length){
            DoubleNode item = tail;
            tail = tail.prev;
            return item.data;
        }
        else {
            int p = 1;
            DoubleNode item = head;
            while (p != index){
                p++;
                item = item.next;
            }
            item.prev.next = item.next;
            item.next.prev = item.prev;
            return item.data;
        }
    }

    //打印整个双向链表
    public void printList(){
        DoubleNode item = head;
        while (item.next != null){
            System.out.println(item.data + "->");
            item = item.next;
        }
        System.out.println(item.data + ".");
    }

    //在某一索引插入元素
    public void insertNode(int index, int data){
        if (index < 1 || index > length){
            System.out.println("索引超出范围");
        }
        else{
            if (index == 1){
                DoubleNode newNode = new DoubleNode(data);
                head.prev = newNode;
                newNode.next = head;
                head = newNode;
                length++;
            }
            else if (index == length){
                DoubleNode newNode = new DoubleNode(data);
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                length++;
            }
            else{
                int p = 1;
                DoubleNode item = head;
                while (p != index-1){
                    p++;
                    item = item.next;
                }
                DoubleNode newNode = new DoubleNode(data);
                item.next.prev = newNode;
                newNode.next = item.next;
                item.next = newNode;
                newNode.prev = item;
                length++;
            }
        }
    }

    public boolean isEmpty(){
        return length == 0;
    }
}

class DoubleNode{
    int data;

    DoubleNode prev = null;

    DoubleNode next = null;

    public DoubleNode(int data) {
        this.data = data;
    }

}