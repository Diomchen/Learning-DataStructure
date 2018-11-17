public class DLLTest {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> d = new DoublyLinkedList<>();
        d.addLast(9);
        d.addLast(19);
        d.addLast(56);
        d.addLast(47);
        d.addLast(38);
        d.addLast(42);
        d.addLast(31);
        d.addLast(75);
        d.addLast(12);
        d.addFirst(1);
        d.addFirst(0);

//        d.removeLast();
//        d.removeFirst();


        System.out.println(d.toString());

    }
}
