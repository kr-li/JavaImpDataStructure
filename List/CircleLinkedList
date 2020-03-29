package CircularLinkedList;

public class CCLinkList {
    int length;

    CCNode head = null;

    public static void main(String[] args) {
        CCLinkList l = new CCLinkList();//引用对象
        //添加结点
        l.appendCCL(1);
        l.appendCCL(2);
        l.appendCCL(3);
        l.appendCCL(4);
        l.appendCCL(5);
        System.out.println(l.getElement(3));


        System.out.println(l.length);
    }
    
    //添加结点
    public void appendCCL(int data){
        CCNode item = head;
        if (head == null){
            head = new CCNode(data);
            item = head;
            length = 1;
            item.next  = head;
        }
        else{
            while (item.next != head){
                item = item.next;
            }
            item.next = new CCNode(data);
            item.next.next = head;
            length ++;
        }
    }
    
    //通过索引获取元素
    public int  getElement(int index){
        CCNode item = head;
        int p = 1;
        if (index < 1 || index > length){
            System.out.println("索引超出范围");
            return 0;
        }
        else{
            while (p != index){
                p ++;
                item = item.next;
            }
            return item.data;
        }
    }


}

//单个结点
class CCNode {
    int data;
    CCNode next = null;

    public CCNode(int data) {
        this.data = data;
    }
}

