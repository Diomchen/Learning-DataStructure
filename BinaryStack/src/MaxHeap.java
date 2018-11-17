public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(){
        data = new Array<>();
    }

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(data.getSize()-1); i >= 0; i--) {
            siftDown(i);
        }

    }

    public int getSize(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.getSize() == 0;
    }

    private int parent(int index){
        if(index == 0)
            throw new IllegalArgumentException("don't find his parent!");
        return (index-1)/2;
    }

    private int leftChild(int index){
        return 2*index+1;
    }

    private int rightChild(int index){
        return 2*index+2;
    }

    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize()-1);
    }

    private void siftUp(int k){
        while(k>0 && data.get(parent(k)).compareTo(data.get(k))<0){
            data.swap(parent(k),k);
            k = parent(k);
        }
    }

    public E findMax(){
        if(data.getSize() == 0)
            throw new IllegalArgumentException("Size is equal to '0'");
        return data.get(0);
    }

    public E extractMax(){
        E ret = findMax();

        data.swap(0,data.getSize()-1);
        data.removeLast();
        siftDown(0);

        return ret;

    }

    private void siftDown(int k){
        while(leftChild(k)<data.getSize()){
            int j = leftChild(k);
            if((j+1)<data.getSize() && data.get(j+1).compareTo(data.get(j))>0){
                j = rightChild(k);
            }

            if(data.get(k).compareTo(data.get(j))>=0)
                break;

            data.swap(k,j);
            k = j;
        }
    }

    public E replace(E e){
        E ret = data.get(0);

        data.set(0,e);
        siftDown(0);

        return ret;
    }

}
