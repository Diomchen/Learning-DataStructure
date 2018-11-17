package com.LinkedList;

import com.sun.nio.sctp.IllegalReceiveException;

public class LinkedListQueue<E> implements IQueue<E> {
    private static class Node<E>{
//        private E e;
//        private Node<E> next;

        public E e;
        public LinkedListQueue.Node<E> next;
        public Node(E e, LinkedListQueue.Node<E> n){
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

    private Node<E> head,tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if(tail == null){
            tail = new Node(e);
            head = tail;
            size++;
        }
        else{
            tail.next = new Node(e);
            tail = tail.next ;
            size++;
        }
    }

    @Override
    public E dequeue() {
        if(isEmpty() )
            throw new IllegalReceiveException("Error");
        Node<E> retHead = head;
        head = head.next;
        retHead.next = null;
        if(head == null){
            tail = null;
        }
        size--;
        return retHead.e;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Error");
        return head.next.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getCapacity() {
        return 0;
    }

}
