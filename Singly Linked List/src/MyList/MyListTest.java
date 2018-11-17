package MyList;

//Stack
public class MyListTest<E> implements IStack<E>{
    Array<E> array;

    public MyListTest(int capacity){
        array = new Array<>(capacity);
    }

    public MyListTest(){
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
        return "MyListTest{" +
                "array=" + array +
                '}';
    }

}
