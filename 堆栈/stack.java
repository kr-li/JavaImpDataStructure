package Stack;

public class Stack {
    private Object[] elements;

    private int index;

    private int size;

    public Object[] getElements() {
        return elements;
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Stack(int size) {
        this.size = size;
        this.elements = new Object[size];
        this.index = -1;
    }

    //入栈
    public void push(Object data){
        if (index >= elements.length){
            throw new RuntimeException("stack is empty");
        }
        index++;
        elements[index] = data;
        System.out.println("入栈元素" + data + ",栈针指向" + index);
    }

    //出站
    public Object pop(){
        if (index <= -1){
            throw new RuntimeException("stack is empty");
        }
        System.out.println("弹栈" + elements[index] + "成功");
        index--;
        return elements[index];
    }

    public static void main(String[] args) {
        Stack s = new Stack(10);
        s.push(new Object());
        s.push(new Object());
        s.push(new Object());
        s.push(new Object());
        s.push(new Object());
        s.pop();
        s.pop();
        s.pop();

    }
}
