package Array;

import java.util.Arrays;

public class MyArray {

    int[] elements;

    public MyArray() {
        elements = new int[0];
    }

    public int getSize(){
        return elements.length;
    }

    //在原数组末尾添加元素，并返回该元素
    public int append(int data){
        int[] newArray = new int[elements.length+1];
        for (int i = 0; i < elements.length; i++){
            newArray[i] = elements[i];
        }
        newArray[elements.length] = data;
        elements = newArray;
        return data;
    }

    //打印数组
    public void printArray(){
        System.out.println(Arrays.toString(elements));
    }

    //删除某一索引元素
    public void pop(int index){
        if (index < 0 || index > elements.length-1){
            throw new RuntimeException("索引超出范围");
        }
        else{
            int[] newArray = new int[elements.length-1];
            for (int i = 0; i < newArray.length; i++){
                if (i < index){
                    newArray[i] = elements[i];
                }
                else{
                    newArray[i] = elements[i+1];
                }
            }
            elements = newArray;
        }
    }

    //去指定索引的元素
    public int getElement(int index){
        return elements[index];
    }

    //在某一位置插入元素
    public void insertElement(int index, int data){
        if (index < 0 || index > elements.length-1){
            throw new RuntimeException("索引超出范围");
        }
        else{
            int[] newArray = new int[elements.length+1];
            for (int i = 0; i < newArray.length; i++){
                if (i < index){
                    newArray[i] = elements[i];
                }
                else if (i == index){
                    newArray[i] = data;
                }
                else{
                    newArray[i] = elements[i-1];
                }
            }
            elements = newArray;
        }

    }

    //替换数组中某个位置的元素
    public void replaceElement(int index, int data){
        if (index < 0 || index > elements.length-1){
            throw new RuntimeException("索引超出范围");
        }
        else{
            int[] newArray = new int[elements.length];
            for (int i = 0; i < elements.length; i++){
                if (i != index){
                    newArray[i] = elements[i];
                }
                else{
                    newArray[i] = data;
                }
            }
            elements = newArray;
        }
    }



    public static void main(String[] args) {
        //测试
        MyArray a = new MyArray();
        a.append(222);
        a.append(123);
        a.append(124);
        a.append(126);
        a.append(12);
        a.append(3);
        a.append(1);
        a.replaceElement(2,0);
        a.insertElement(5,100);
        a.pop(1);
        System.out.println(a.getElement(5));
        a.printArray();
    }
}
