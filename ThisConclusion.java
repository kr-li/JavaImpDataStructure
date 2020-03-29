package Day;

public class ThisConclusion {

    //带有static方法
    public static void method1(){
        //调用doSome
        //完整方式调用
        ThisConclusion.doSome();
        //省略方式调用
        doSome();

        //调用doOther
        //完整方式调用
        ThisConclusion t = new ThisConclusion();
        t.doOther();
        //省略方式调用

        //访问i
        //完整方式访问
        System.out.println(t.i);
        //省略方式访问
    }

    //没有static方法
    public void method2(){
        //调用doSome
        //完整方式调用
        ThisConclusion.doSome();
        //省略方式调用
        doSome();

        //调用doOther
        //完整方式调用
        this.doOther();
        //省略方式调用
        doOther();

        //访问i
        //完整方式访问
        System.out.println(this.i);
        //省略方式访问
        System.out.println(i);

    }

    //主方法
    public static void main(String[] args){
        //要求编写程序调用method1
        //使用完整方式调用
        ThisConclusion.method1();
        //使用省略方式调用
        method1();

        //要求编写程序调用method2
        //使用完整方式调用
        ThisConclusion t = new ThisConclusion();
        t.method2();
        //使用省略方式调用

    }

    //没有static变量
    int i = 10;

    //带有static方法
    private static void doSome(){
        System.out.println("do some!");
    }

    //没有static方法
    private void doOther(){
        System.out.println("do other!");
    }
}
