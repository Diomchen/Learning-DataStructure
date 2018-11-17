public class CircularlyLinkedList<E> {
    private static class Node<E>{
        private E element;
        private Node<E> next;
        //reference to the subsequent ndoe in the List
        public Node(E e ,Node<E> n){
            element = e;
            next = n;
        }
        public E getElement(){
            return element;
        }

        public Node<E> getNext(){
            return next;
        }

        public void setNext(Node<E> n){
            next = n;
        }
    }


    /* Todo:
    * In circular Linked List , the func 'addLast()'
    * is the key step. in particularly, self circulation
    * that ensure the list can circle in true*/

    private Node<E> tail = null;
    //In the circularly Linked List ,we can use store tail to
    //convenient us to do some things than store head
    private int size = 0;

    public CircularlyLinkedList(){}

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if(isEmpty())
            return null;
        return tail.getNext().getElement();
    }

    public E last(){
        if(isEmpty())
            return null;
        return tail.getElement();
    }

    public void rotate(){
        if(tail != null){
            tail = tail.getNext();
        }
    }

    public void addFirst(E e){
        if(size == 0){
            tail = new Node<>(e,null);//set point
            tail.setNext(tail);//set itself circularly,it's the key step
        }
        else{
            Node<E> newest = new Node<>(e,tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    public void addLast(E e){
        addFirst(e);
        tail = tail.getNext();
    }

    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        Node<E> head = tail.getNext();
        if(head == tail){
            tail = null;
        }
        else{
            tail.setNext(tail.getNext().getNext());
        }
        size--;
        return head.getElement();
    }

    @Override
    public String toString() {
        StringBuffer s =new StringBuffer();
        s.append("tail -> ");
        Node<E> node = tail.getNext();
        for(int i=0 ; i<size ; i++){
            s.append(node.getElement() + " -> ");
            node = node.getNext();
        }
        s.append("tail");
        return s.toString();
    }
}
