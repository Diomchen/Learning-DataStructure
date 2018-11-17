package MyList;

public class MyQueue<E> implements IQueue<E> {
    Array<E> array;

    public MyQueue(int capacity){
        array = new Array<>(capacity);
    }

    public MyQueue(){
        array = new Array<>(10);
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
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
    public String toString() {
        return "MyQueue{" +
                "array=" + array +
                '}';
    }
}
