public class BSTtest {
    public static void main(String[] args) {
        BST<Integer> bsf = new BST<>();
//        bsf.add(3);
//        bsf.add(13);
//        bsf.add(25);
//        bsf.add(39);
//        bsf.add(21);
//        bsf.add(74);
//        bsf.add(29);
//        bsf.add(53);
//        bsf.add(42);
//        bsf.add(71);
//        bsf.add(19);
//        bsf.add(44);
//        bsf.add(8);
        bsf.add(4);
        bsf.add(6);
        bsf.add(2);
        bsf.add(3);
        bsf.add(1);
        bsf.add(8);

        System.out.println(bsf.contains(9));
        System.out.println(bsf);
        System.out.println("----------------");
        bsf.inOrder();
        System.out.println("----------------");
        bsf.postOrder();
        System.out.println("----------------");
        bsf.preOrderStack();
        System.out.println("----------------");
        bsf.levelOrderQueue();
        System.out.println("----------------");
        System.out.println(bsf.maxmum());
        System.out.println(bsf.minmum());
        System.out.println("----------------");
        bsf.remove(2);
//        System.out.println(bsf);
        bsf.levelOrderQueue();
        System.out.println("Size:"+bsf.getSize());
    }
}
