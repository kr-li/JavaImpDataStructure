package LinkLIst;

public class LinkList {

    int length = 0;

    Node head = null;

    public static void main(String[] args) {
        LinkList l = new LinkList();
        l.creatLinkList(4);
    }

    //定义一个结点类，包含数据和指向下一个结点的指针
    static class Node{
        int data;
        Node next = null;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    //得到链表长度
    public int getLength() {
        return length;
    }

    //链表末尾添加元素
    public void append(int node){
        Node newNode = new Node(node);
        if (head == null){
            head = newNode;
            length = 1;
        }
        else{
            Node item = head;
            while (item.next != null){
                item = item.next;
            }
            item.next = newNode;
            length ++;
        }
    }

    //找到链表中某一索引元素
    public void getElement(int index){
        if (index < 1 || index > length){
            System.out.println("索引超出链表范围");
            //return 0;
        }
        else {
            int p = 1;
            Node item = head;
            while (p != index){
                p ++;
                item = item.next;
            }
            System.out.println(item.data);
            //return item.data;
        }
    }

    //链表中在某一位置插入元素
    public void insertElement(int index, int data){
        if (index == 1){
            this.head = new Node(data, head);//新结点的指针指向头结点
            length ++;
        }
        else{
            int p = 1;
            Node item = head;
            while (p != index-1){
                item = item.next;
                p ++;
            }
            item.next = new Node(data, item.next);//index位置元素指向下一个元素，该位置插入新元素
            length ++;
        }
    }

    //打印链表
    public void printList(){
        if (length == 0){
            System.out.println("list is empty");
        }
        else{
            Node item = head;
            System.out.println(item.data + "->");
            while (item.next != null){
                item = item.next;
                System.out.println(item.data + "->");
            }

        }
    }

    //清空链表
    public void clearList(){
        this.head = null;
        this.length = 0;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return length == 0;
    }

    //确定某一值数据的位置,返回数据下标，若无该数据，返回0
    public int locateElement(int x){
        if (head == null){
            System.out.println("linklist is empty");
            return 0;
        }
        else{
            int p = 1;
            Node item = head;
            while (item.data != x){
                p ++;
                if (item.next != null){
                    item = item.next;
                }
                else{
                    return 0;
                }
            }
            return p;
        }
    }

    //更新某一个位置元素的数据
    public void updateElement(int index, int data){
        Node item = head;
        int p = 1;
        if (index < 1 || index > length){
            System.out.println("索引超出范围");
        }
        else{
            while (p != index){
                p += 1;
                item = item.next;
            }
            item.data = data;
        }
    }

    //创建一个数据连续的链表
    public void creatLinkList(int x){
        Node n = new Node(1);
        head = n;
        Node item = head;
        int p = 1;
        length = 1;
        while (p < x){
            p ++;
            length ++;
            Node newNode = new Node(p);
            item.next = newNode;
            item = item.next;
        }
    }

    //翻转列表
    public void reverseIteratively(Node head) {
        Node pReversedHead = head;
        Node pNode = head;
        Node pPrev = null;
        while (pNode != null) {
            Node pNext = pNode.next;
            if (pNext == null) {
                pReversedHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        this.head = pReversedHead;
    }

    //找中间结点,快慢指针方法。
    public void searchMid(){
        Node p = head;
        Node q = head;
        while (q != null && q.next!= null && q.next.next != null){
            p = p.next;
            q = q.next.next;
        }
        System.out.println(p.data);
    }
}

