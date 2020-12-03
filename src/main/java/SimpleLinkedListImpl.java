
public class SimpleLinkedListImpl<E> implements SimpleLinkedList<E> {

    SimpleLinkedListImpl.Node<E> first;
    SimpleLinkedListImpl.Node<E> last;

    int size = 0;

    private static class Node<E> {
        E element;
        SimpleLinkedListImpl.Node<E> next;
        SimpleLinkedListImpl.Node<E> prev;

        public Node(E element) {
            this.element = element;
        }
    }

    public SimpleLinkedListImpl() {

    }

    public int size() {
        return size;
    }

    public void add(int index, E element) throws RuntimeException {
        SimpleLinkedListImpl.Node<E> nowElement = null;

        try {
            nowElement = findElement(index);
        } catch (NullPointerException e) {
            //e.printStackTrace();
        }
        if (nowElement == null) {
            if (size == 0) {
                first = new SimpleLinkedListImpl.Node<E>(element);
                first.prev = null;
                size++;
            } else if (size == 1) {
                last = new SimpleLinkedListImpl.Node<E>(element);
                last.next = null;
                last.prev = first;
                size++;
            } else {
                nowElement = last;
                last = new SimpleLinkedListImpl.Node<E>(element);
                last.prev = nowElement;
                nowElement.next = last;
                size ++;
            }
        } else {
            nowElement.element = element;
        }
    }

    public void remote(int index) throws RuntimeException {
        SimpleLinkedListImpl.Node<E> nowElement = null;
        try {
            nowElement = findElement(index);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        SimpleLinkedListImpl.Node<E> nextElement = null;
        if (index != size - 1) {
            nextElement = nowElement.next;
        }
        SimpleLinkedListImpl.Node<E> prevElement = null;
        if (index != 0) {
            prevElement = nowElement.prev;
        }

        if (index == 0) {
            first = nextElement;
            first.prev = null;
        } else if (index == size - 1) {
            last = prevElement;
            last.next = null;
        } else {
            prevElement.next = nextElement;
            nextElement.prev = prevElement;
        }
        size--;

    }

    public void clear() {
        SimpleLinkedListImpl.Node<E> nowElement = first;

        for (int i = 0; i < size; i++) {
            SimpleLinkedListImpl.Node<E> next = null;
            try {
                next = nowElement.next;
                nowElement.element = null;
                nowElement.next = null;
                nowElement.prev = null;
                nowElement = next;
            } catch (NullPointerException e) {
               // e.printStackTrace();
            }
            // SimpleLinkedListImpl.Node<E> next = nowElement.next;
        }
        first = last = null;
        size = 0;
    }

    public int indexOf(E element) throws RuntimeException {
        SimpleLinkedListImpl.Node<E> nowElement = first;
        for (int i = 1; i <= size; i++) {
            if (nowElement.element.equals(element)) {
                return i;
            }
            nowElement = nowElement.next;
        }
        return -1;
    }

    private SimpleLinkedListImpl.Node<E> findElement(int index) {

        if(index == -1) return null;
        SimpleLinkedListImpl.Node<E> nowElement = first;
        if (index == 0) {
            return first;
        }
        for (int i = 1; i <= index; i++) {
            nowElement = nowElement.next;
            if (i == index) {
                return nowElement;
            }
        }
        return null;
    }
}
