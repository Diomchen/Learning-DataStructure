package MyList;

public class Main {

    public static void main(String[] args) {
        MyLoopQueue<Integer> ms = new MyLoopQueue<>(10);
        ms.enqueue(6);
        ms.enqueue(87);
        ms.enqueue(44);
        ms.enqueue(23);
        ms.enqueue(45);
        ms.enqueue(87);
        ms.enqueue(56);
        ms.enqueue(88);

        ms.enqueue(44);
        ms.enqueue(23);
        ms.enqueue(45);
        ms.enqueue(87);
        ms.enqueue(56);
        ms.enqueue(88);

        System.out.println(ms.dequeue());
        System.out.println(ms.getFront());


        System.out.println(ms.toString());
        System.out.print("size : "+ms.getSize());
        System.out.println("  capacity : "+ms.getCapacity());
    }
}
