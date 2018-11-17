public class DoubleCircularlyLinkedLists<E> {
    public class Node<E>{
        private E e;
        private Node<E> next;
        private Node<E> prev;

        public Node(E e,Node<E> next,Node<E> prev){
            this.e = e;
            this.next = next;
            this.prev = prev;
        }
        public Node(){
            this.e = null;
            this.next = null;
            this.prev = null;
        }

        public E getElement(){
            return e;
        }

        public Node<E> getNext(){
            return next;
        }

        public Node<E> getPrev(){
            return prev;
        }

        public void setNext(Node<E> n){
            next = n;
        }

        public void setPrev(Node<E> p){
            prev = p;
        }
    }

    private Node<E> dummyHead = new Node<>();
    private int size = 0;

    public DoubleCircularlyLinkedLists(){
        dummyHead.setNext(dummyHead);
        dummyHead.setPrev(dummyHead);
    }

    public int getSize(){return size;}
    public boolean isEmpty(){return size == 0;}

    public E first(){
        if(isEmpty())
            return null;
        return dummyHead.getNext().getElement();
    }

    public E last(){
        if(isEmpty())
            return null;
        return dummyHead.getPrev().getElement();
    }

//    public void rotate(){
//
//    }

    public void addFirst(E e){
        if(isEmpty()){
            Node<E> newest = new Node<>(e ,dummyHead, dummyHead);
            dummyHead.setPrev(newest);
            dummyHead.setNext(newest);
        }
        else{
            Node<E> newest = new Node<>(e,dummyHead.getNext() ,dummyHead);
            dummyHead.getNext().setPrev(newest);
            dummyHead.setNext(newest);
        }
        size++;
    }

    public void addLast(E e){
        if(isEmpty()){
            Node<E> newest = new Node<>(e ,dummyHead, dummyHead);
            dummyHead.setPrev(newest);
            dummyHead.setNext(newest);
        }
        else{
            Node<E> newest = new Node<>(e, dummyHead , dummyHead.getPrev() );
            dummyHead.getPrev().setNext(newest);
            dummyHead.setPrev(newest);
        }
        size++;
    }

    public E removeFirst(){
        if(isEmpty())
            return null;
        Node<E> delNode = dummyHead.getNext();
        delNode.getNext().setPrev(dummyHead);
        dummyHead.setNext(delNode.getNext());
        delNode.setNext(null);
        delNode.setPrev(null);
        size--;
        return delNode.getElement();
    }

    public E removeLast(){
        if(isEmpty())
            return null;
        Node<E> delNode = dummyHead.getPrev();
        delNode.getPrev().setNext(dummyHead);
        dummyHead.setPrev(delNode.getPrev());
        delNode.setNext(null);
        delNode.setPrev(null);
        size--;
        return delNode.getElement();
    }

    public String toString(){
        StringBuffer s =new StringBuffer();
        s.append("dummyHead <-> ");
        Node<E> cur = dummyHead.getNext();

        for(int i=0 ; i<=size+1 ; i++){
            s.append(cur.getElement()+" <-> ");
            cur = cur.getNext();
        }
        s.append("dummyHead");

        return s.toString();
    }

}
