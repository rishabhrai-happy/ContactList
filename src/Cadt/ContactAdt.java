package Cadt;

public interface ContactAdt<E> {
    boolean add(E item);

    E remove(int data);

    int search(E item);


    void sort();


}
