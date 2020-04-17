package Trees;

public class ThreadedBinaryTree {
    ThreadedNode root;

    //设置根结点
    public void setRoot(ThreadedNode root) {
        this.root = root;
    }

    //临时存储前驱结点
    ThreadedNode pre = null;

    //中序线索化二叉树
    public void threadNodes(){
        threadNodes(root);
    }

    public void threadNodes(ThreadedNode node){
        if (node == null){
            return;
        }

        //处理左子树
        threadNodes(node.leftChild);

        //处理当前结点左指针
        if (node.leftChild == null){
            //将当前结点左指针变为前驱结点
            node.leftChild = pre;
            //改变左指针类型
            node.leftType = 1;
        }
        //处理前驱结点的右指针
        if (pre != null && pre.rightChild == null){
            pre.rightChild = node;
            pre.rightType = 1;
        }

        //将该结点变为前驱结点
        pre = node;

        //处理右子树
        threadNodes(node.rightChild);


    }


    public static void main(String[] args) {
        ThreadedBinaryTree tree = new ThreadedBinaryTree();
        ThreadedNode node1 = new ThreadedNode(0);
        ThreadedNode node2 = new ThreadedNode(1);
        ThreadedNode node3 = new ThreadedNode(2);
        ThreadedNode node4 = new ThreadedNode(3);
        ThreadedNode node5 = new ThreadedNode(4);
        tree.setRoot(node1);
        tree.root.setRightChild(node3);
        tree.root.setLeftChild(node2);
        node2.setLeftChild(node4);
        node3.setRightChild(node5);
        tree.threadNodes();
        System.out.println(node5.leftChild);
    }

}

class ThreadedNode{
    int data;

    ThreadedNode leftChild;

    ThreadedNode rightChild;

    int leftType;

    int rightType;

    public ThreadedNode(int data) {
        this.data = data;
    }

    //设置左儿子
    public void setLeftChild(ThreadedNode leftChild) {
        this.leftChild = leftChild;
    }

    //设置右儿子
    public void setRightChild(ThreadedNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "ThreadedNode{" +
                "data=" + data +
                ", leftType=" + leftType +
                ", rightType=" + rightType +
                '}';
    }

    //结点前序查找
    public ThreadedNode frontSearch(int data){
        ThreadedNode target = null;
        if (this.data == data){
            return this;
        }
        else {
            if (leftChild != null){
                target = leftChild.frontSearch(data);
            }
            if (target != null){
                return target;
            }
            if (rightChild != null){
                target = rightChild.frontSearch(data);
            }
        }
        return target;
    }

}