package MyList;

public interface IQueue <E>{
    void enqueue(E e);
    E dequeue();
    E getFront();
    int getSize();
    boolean isEmpty();
    default int getCapacity(){
        return 0;
    };
}
