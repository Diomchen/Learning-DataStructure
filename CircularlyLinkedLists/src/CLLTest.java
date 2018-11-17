public class CLLTest {
    public static void main(String[] args) {
        CircularlyLinkedList<Integer> cTest = new CircularlyLinkedList<>();

        cTest.addLast(6);
//        cTest.rotate();
        cTest.addLast(46);
//        cTest.rotate();
        cTest.addLast(53);
        cTest.addLast(46);
        cTest.addLast(89);
        cTest.addLast(976);

        cTest.removeFirst();
//        cTest.rotate();



        System.out.println(cTest.toString());


    }
}
