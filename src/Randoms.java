import java.util.Iterator;
import java.util.NoSuchElementException;

class MyLinkedList<T> implements Iterable<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private int size = 0;

    // Добавление элемента
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Получение размера
    public int size() {
        return size;
    }

    // Итератор
    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<T> {
        private Node<T> current = head;
        private Node<T> previous = null;
        private Node<T> previousPrevious = null;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.data;
            previousPrevious = previous;
            previous = current;
            current = current.next;
            return data;
        }

        @Override
        public void remove() {
            if (previous == null) {
                throw new IllegalStateException("next() не вызван или элемент уже удален");
            }
            if (previousPrevious == null) {
                head = current;
            } else {
                previousPrevious.next = current;
            }
            previous = null;
            size--;
        }
    }
}