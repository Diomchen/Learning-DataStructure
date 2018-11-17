package MyList;

public class MyLoopQueue<E> implements IQueue<E> {
    private E[] data;
    private int front;
    private int tail;


    public MyLoopQueue(int capacity){
        data = (E[])new Object[capacity+1];
        front = 0;
        tail = 0;
    }

    public  MyLoopQueue(){
        this(10);
    }


    @Override
    public void enqueue(E e) {
        if(front == (tail+1)%data.length) {
            resize(data.length * 2);
        }
        tail = tail%data.length;
        data[tail] = e;
        tail++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Error");
        E s = data[front];
        data[front] = null;
        front = (front+1)%data.length;
        if(getCapacity()/4 == setSize(front,tail) && getCapacity()/2!=0){
            resize(data.length/2);
        }

        return s;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    private int setSize(int front,int tail) {
        int mid = 0;
        if(front<tail){
            mid = tail - front;
        }
        if(front>tail){
            mid = data.length-front+1+tail;
        }
        if(front == tail){
            mid = 0;
        }
        return mid;
    }

    @Override
    public int getSize(){
        return setSize(front,tail);
    }

    @Override
    public boolean isEmpty() {
        return setSize(front,tail)  == 0;
    }

    private void resize(int newCapacity ){
        E[] newData = (E[])new Object[newCapacity+1];
        for(int i=0 ; i<newCapacity ; i++){
            newData[i] = data[(i+front)%data.length];
        }

        front = 0;
        tail = setSize(front,tail);
        data = newData;
    }
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("front [");
        for (int i = front; (i % data.length) < tail ; i++) {
            s.append(data[i]);
            if( i%data.length != tail-1)
                s.append(",");
        }
        s.append("] tail");
        return s.toString();
    }
    @Override
    public int getCapacity(){
        return data.length-1;
    }
}
