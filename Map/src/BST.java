import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node right,left;

        public Node(E e){
            this.e = e;
            right = null;
            left = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /*public void add(E e){
        if(root == null){
            root = new Node(e);
            size++;
        }
        else{
            add(root,e);
        }
    }*/

    /*public void add(Node node,E e){
        if(e.equals(node.e)){
            return;
        }
        else if(e.compareTo(node.e) < 0 && node.left == null){
            node.left = new Node(e);
            size++;
            return;
        }
        else if(e.compareTo(node.e) > 0 && node.right == null){
            node.left = new Node(e);
            size++;
            return;
        }

        if(e.compareTo(node.e)<0){
            add(node.left,e);
        }
        else{
            add(node.right,e);
        }
    }*/
    //we can develop these thought

    public void add(E e){
        root = add(root,e);
    }

    private Node add(Node node,E e){
        if(node == null){
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e) <0 ){
            node.left = add(node.left,e);
        }
        else if(e.compareTo(node.e) > 0){
            node.right = add(node.right,e);
        }

        return node;
    }

    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node, E e){
        if(node == null){
            return false;
        }

        if(e.compareTo(node.e) == 0){
            return true;
        }
        else if(e.compareTo(node.e) < 0 ){
            return contains(node.left, e);
        }
        else{
            return contains(node.right,e);
        }
    }
    //广度优先遍历(层序遍历)
    public void levelOrderQueue(){
        Queue<Node> d = new LinkedList<>();
        d.add(root);

        while(!d.isEmpty()){
            Node cur = d.remove();
            System.out.println(cur.e);

            if(cur.left!=null)
                d.add(cur.left);
            if(cur.right!=null)
                d.add(cur.right);
        }

    }

    //深度优先前序遍历
    public void preOrderStack(){
        Stack<Node> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            Node cur = s.pop();
            System.out.println(cur.e);

            if(cur.right!=null)
                s.push(cur.right);
            if(cur.left!=null)
                s.push(cur.left);

        }
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node!=null){
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node!=null){
            inOrder(node.left);
            System.out.println(node.e);
            inOrder(node.right);
        }
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node!=null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.e);
        }
    }

    public E minmum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is Empty");
        return minmum(root).e;
    }

    private Node minmum(Node node){
        if(node.left == null)
            return node;

        return minmum(node.left);
    }

    public E removeMin(){
        E ret = minmum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node){
        if(node.left == null){
            Node nodeRight = node.right;
            node.right = null;
            size--;
            return nodeRight;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public E maxmum(){
        return maxmum(root).e;
    }

    private Node maxmum(Node node){
        if(node.right == null)
            return node;
        return maxmum(node.right);
    }

    public E removeMax(){
        E ret = maxmum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node){
        if(node.right==null){
            Node nodeLeft = node.left;
            node.left = null;
            size--;
            return nodeLeft;
        }

        node.right = removeMax(node.right);
        return node;
    }


    public void remove(E e){
        root = remove(root , e);
    }

    private Node remove(Node node , E e){
        if(node == null)
            return null;

        if(e.compareTo(node.e)<0){
            node.left = remove(node.left,e);
            return node;
        }
        else if(e.compareTo(node.e)>0){
            node.right = remove(node.right,e);
            return node;
        }
        else{
            if(node.left == null){
                Node nodeRight = node.right;
                node.right = null;
                size--;
                return nodeRight;
            }
            else if(node.right == null){
                Node nodeLeft = node.left;
                node.left = null;
                size--;
                return nodeLeft;
            }
            else{
                Node nodeRight = node.right;
                Node nodeLeft = node.left;
                node.right = null;
                node.left = null;
                Node nodeMid = minmum(nodeRight);
                nodeMid.left = nodeLeft;
                size--;
                return nodeMid;
//-----------------------------------------------------
//                Node successor = minmum(node.right);
//                successor.right = removeMin(node.right);
                //由于这里进行了removeMin（）操作，所以不需要再进行size--；
                //但上面，我写的那种方法 ，则需要size--；
//                successor.left = node.left;
//                node.left = node.right = null;
//                return successor;
            }
        }



    }
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTtoString(root,0,res);
        return res.toString();
    }

    private void generateBSTtoString(Node node , int depth , StringBuilder res){
        if(node == null){
            res.append(generateDepthtoString(depth)+"null\n");
            return;
        }

        res.append(generateDepthtoString(depth)+node.e+"\n");
        generateBSTtoString(node.left, depth+1 ,res);
        generateBSTtoString(node.right, depth+1 ,res);

    }

    private String generateDepthtoString (int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

}
