public class DCLLTest {
    public static void main(String[] args) {
        DoubleCircularlyLinkedLists<Integer> d = new DoubleCircularlyLinkedLists<>();

        d.addLast(3);
        d.addLast(23);
        d.addLast(18);
        d.addLast(19);
        d.addLast(75);
        d.addLast(46);
        d.addLast(9);
        d.addLast(19);
        d.addLast(34);
        d.addLast(39);
        d.addLast(76);

        System.out.println(d.toString());
    }
}
