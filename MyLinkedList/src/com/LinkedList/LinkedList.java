package com.LinkedList;

public class LinkedList<E> {
    private static class Node<E>{
//        private E e;
//        private Node<E> next;

        public E e;
        public Node<E> next;
        public Node(E e,Node<E> n){
            this.e = e;
            next = n;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node<E> dummyHead ;
    private int size ;

    public LinkedList(){
        dummyHead = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E get(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Error");

        Node<E> cur = dummyHead.next;
        int i = 0;
        while(i<index){
            cur = cur.next;
            i++;
        }
        return  cur.e;
    }


    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    public void set(E e , int index ){
        if(isEmpty())
            throw new IllegalArgumentException("Error");
        if(index<0 || index >size)
            throw new IllegalArgumentException("Error");

        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e){
        Node<E> cur = dummyHead.next;
        while(cur != null){
            if(e.equals(cur.e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void addFirst(E e){
        add(e,0);
//      head = new Node(e,head);

    }

    public void addLast(E e){
        add(e,size);

    }

    public void add(E e,int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Error");

        Node node = new Node(e);
        Node prev = dummyHead;

        for(int i=0 ; i<index ; i++){
            prev = prev.next;
        }

        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public E remove(int index){
        if(isEmpty())
            throw new IllegalArgumentException("Error");
        if(index<0 || index>size)
            throw new IllegalArgumentException("Error");

        Node prev = dummyHead;
        for(int i=0 ; i<index ; i++){

            prev = prev.next;
        }

        Node<E> delcur = prev.next;
        E s = delcur.e;
        prev.next = delcur.next;
        delcur.next = null;

        size--;
        return s;
    }

//    public void remove(E e){
//        if(isEmpty())
//            throw new IllegalArgumentException("Error");
//
//        if(contains(e))
//            throw new IllegalArgumentException("Error");
//
//        Node cur = dummyHead.next;
//        Node prev = dummyHead;
//        while(cur != null){
//            cur = cur.next;
//            prev = prev.next;
//            if(cur.e.equals(e)){
//                prev.next = cur.next;
//                cur.next = null;
//                cur = prev;
//            }
//        }
//        size--;
//    }

    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size-1);
    }

//    public void sortInsert  (E e){
//        LinkedList<E> newL = new LinkedList<>();
//
//    }

    public String toString(){
        StringBuffer s = new StringBuffer();
        s.append("dummyHead -> ");
        Node<E> cur = dummyHead.next;
        while(cur != null){
            s.append(cur.e);
            s.append(" -> ");
            cur = cur.next;
        }
        s.append("Null");

        return s.toString();
    }
}
