package Stack;

public class StackArray {

    //栈底层用数组存储数据
    int[] elements;

    public StackArray() {
        this.elements = new int[0];
    }

    //压入元素
    public void pushElement(int data){
        int[] newArray = new int[elements.length+1];
        for (int i = 0; i < elements.length; i++){
            newArray[i] = elements[i];
        }
        newArray[elements.length] = data;
        elements = newArray;
    }

    //取出栈顶元素
    public int pop(){
        if (elements.length == 0){
            throw new RuntimeException("stack is empty");
        }
        else{
            int element = elements[elements.length - 1];
            int[] newArray = new int[elements.length - 1];
            for (int i = 0; i < elements.length-1; i++){
                newArray[i] = elements[i];
            }
            elements = newArray;
            return element;
        }
    }

    //查看栈顶元素
    public int peek(){
        return elements[elements.length-1];
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return elements.length == 0;
    }

    public static void main(String[] args) {
        StackArray sa = new StackArray();
        sa.pushElement(12);
        sa.pushElement(0);
        sa.pushElement(100);
        System.out.println(sa.peek());
        System.out.println(sa.pop());
    }
}
