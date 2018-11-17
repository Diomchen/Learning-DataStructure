import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(20);
        Random random = new Random();

        for (int i = 0; i < 20 ; i++) {
            maxHeap.add(random.nextInt(10));
        }

        int[] arr = new int [20];
        for (int i = 0; i < 20; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (Integer x:arr){
            System.out.println(x);
        }



    }

}
