public class BSTMap< K extends Comparable<K> , V > implements Map< K , V > {

    private class Node{
        public K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }

    }

    private Node root;
    private int size;

    public BSTMap(){
        root = null;
        size = 0;
    }

    private Node getNode(Node node , K key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key)<0){
            return getNode(node,key);
        }
        else if(key.compareTo(node.key)>0){
            return getNode(node,key);
        }
        else{
            return node;
        }
    }

    @Override
    public void add(K key, V value) {
        root = add(root , key , value );
    }

    private Node add(Node node , K key , V value ){
        if(node == null){
            size++;
            return new Node(key , value);
        }

        if(key.compareTo(node.key)<0){
            node.left = add(node,key,value);
        }
        else if(key.compareTo(node.key)>0){
            node.right = add(node,key,value);
        }

        return node;
    }

    @Override
    public V remove(K key) {
        return remove(root,key).value;
    }

    private Node remove(Node node,K key){
        if(node == null){
            return null;
        }

        if(key.compareTo(node.key)<0){
            node.left = remove(node,key);
            return node;
        }
        else if(key.compareTo(node.key)>0){
            node.right = remove(node,key);
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
                Node nodeMid = minmun(nodeRight);
                nodeMid.left = nodeLeft;
                size--;
                return nodeMid;
            }
        }

    }

    private Node minmun(Node node){
        if(node.left == null){
            return null;
        }
        return minmun(node.left);
    }

    @Override
    public boolean contains(K key, V value) {
        return contains(root,key,value);
    }

    private boolean contains(Node node,K key, V value){
        if(node == null){
            return false;
        }

        if(key.compareTo(node.key)<0){
            return contains(node,key,value);
        }
        else if(key.compareTo(node.key)>0){
            return contains(node,key,value);
        }
        else{
            return true;
        }

    }

    @Override
    public V get(K key) {
        return get(root,key);
    }
    private V get(Node node,K key){
        if(node == null){
            return null;
        }

        if(key.compareTo(node.key)<0){
            return get(node,key);
        }
        else if(key.compareTo(node.key)>0){
            return get(node,key);
        }
        else{
            return node.value;
        }
    }

    @Override
    public void set(K key, V value) {
        Node node  = getNode(root,key);
        if(node == null )
            throw new IllegalArgumentException(key+"is not exist");
        node.value = value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
