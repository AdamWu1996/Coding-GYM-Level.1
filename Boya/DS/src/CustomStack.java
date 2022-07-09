import java.util.*;

public class CustomStack<E> implements Iterable<E> {
    private Object[] list;
    private int next;
    private boolean popFromHead = false;
    private Comparator<E> comparator;

    public CustomStack(int capacity) {
        list = new Object[capacity];
    }

    public CustomStack() {
        this(1);
    }

    public CustomStack(Comparator<E> comparator) {
        this();
        this.comparator = comparator;
    }

    public void sort() {
        Arrays.sort((E[]) list, comparator);
    }

    public void push(E e) {
        if (next == list.length) {
            list = Arrays.copyOf(list, list.length + 1);
        }
        list[next++] = e;
        Arrays.sort(list);
    }

    public void pop() {
        Object popNum;
        if (next == -1) {
            return;
        }
        if (!popFromHead) {
            popNum = list[0];
            list = Arrays.copyOfRange(list, 1, list.length);
            popFromHead = true;
        } else {
            popNum = list[next - 1];
            list = Arrays.copyOf(list, list.length - 1);
            popFromHead = false;
        }
        next--;
        System.out.println("POP:" + popNum);
    }

    public void show() {
        for (Object o : list) {
            System.out.print(o + " ");
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < next;
            }

            @Override
            public E next() {
                return (E) list[index++];
            }
        };
    }
}
