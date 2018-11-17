package com.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedListStack<Integer> LL = new LinkedListStack<>();
        LL.push(3);
        LL.push(54);
        LL.push(65);
        LL.push(34);
        LL.push(56);

        LL.push(19);
        LL.push(34);
        LL.push(17);
        LL.push(42);
        LL.push(99);

        LL.push(135);

//        LL.add(999,3);
//        LL.remove(999);
//        System.out.println(LL.remove(3));
//        System.out.println(LL.removeFirst());
//        System.out.println(LL.removeLast());
//        LL.set(88,1);
        System.out.println(LL.getSize());
//        System.out.println(LL.get(3));
//        System.out.println(LL.contains(3));

        System.out.println(LL.pop());
        System.out.println(LL.peek());

        System.out.println(LL.toString());


    }
}
