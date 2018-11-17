package com.LinkedList;

//Stack
public class MyStack<E> implements IStack<E>{
    Array<E> array;

    public MyStack(int capacity){
        array = new Array<>(capacity);
    }

    public MyStack(){
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "array=" + array +
                '}';
    }

}
