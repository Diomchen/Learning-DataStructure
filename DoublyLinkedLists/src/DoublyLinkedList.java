public class DoublyLinkedList<E> {
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

    private Node<E> header = new Node<>();
    private Node<E> trailer = new Node<>();
    private int size = 0;

    public DoublyLinkedList(){
        header.setNext(trailer);
        trailer.setPrev(header);
    }


    public int getSize(){return size;}

    public boolean isEmpty(){return size == 0;}

    public E first(){
        if(isEmpty())
            return null;
        return header.getNext().getElement();
    }

    public E last(){
        if(isEmpty())
            return null;
        return trailer.getPrev().getElement();
    }

    public void addFirst(E e){
        if(isEmpty()){
            Node<E> newest = new Node<>(e,header.getNext(),trailer.getPrev());
            header.setNext(newest);
            trailer.setPrev(newest);
        }
        else{
            Node<E> newest = new Node<>(e,header.getNext(),header);
            header.getNext().setPrev(newest);
            header.setNext(newest);

        }
        size++;
    }

    public void addLast(E e){
        if(isEmpty()){
            Node<E> newest = new Node<>(e,header.getNext(),trailer.getPrev());
            header.setNext(newest);
            trailer.setPrev(newest);
        }
        else{
            Node<E> newest = new Node<>(e,trailer,trailer.getPrev());
            trailer.getPrev().setNext(newest);
            trailer.setPrev(newest);

        }
        size++;
    }

    public E removeFirst(){
        if(isEmpty())
            return null;
        Node<E> delNode = header.getNext();
        header.setNext(delNode.getNext());
        delNode.getNext().setPrev(header);
        delNode.setPrev(null);
        delNode.setNext(null);
        size--;
        return delNode.getElement();
    }

    public E removeLast(){
        if(isEmpty())
            return null;
        Node<E> delNode = trailer.getPrev();
        header.setPrev(delNode.getPrev());
        delNode.getPrev().setNext(trailer);
        delNode.setPrev(null);
        delNode.setNext(null);
        size--;
        return delNode.getElement();
    }

    public String toString(){
        StringBuffer s = new StringBuffer();
        Node<E> cur = header.getNext();

        s.append("header <-> ");
        for(int i=0 ; i<size ; i++){
            s.append(cur.getElement() + " <-> ");
            cur = cur.getNext();
        }
        s.append("trailer");

        return s.toString();
    }



}
