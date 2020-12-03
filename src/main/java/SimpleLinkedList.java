public interface SimpleLinkedList<E> {

    int size();

    void add(int index, E element) throws RuntimeException;

    void remote(int index) throws RuntimeException;

    void clear();

    int indexOf(E element) throws RuntimeException;

}