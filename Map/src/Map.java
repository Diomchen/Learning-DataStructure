public interface Map < K extends Comparable<K>, V > {

    void add(K key, V value);
    V remove(K key );
    boolean contains(K key ,V value);
    V get(K key);
    void set(K Key , V value);
    int getSize();
    boolean isEmpty();

}
