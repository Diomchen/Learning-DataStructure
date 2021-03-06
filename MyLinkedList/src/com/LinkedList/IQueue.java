package com.LinkedList;

public interface IQueue<E>{
    void enqueue(E e);
    E dequeue();
    E getFront();
    int getSize();
    boolean isEmpty();
    int getCapacity();
}
