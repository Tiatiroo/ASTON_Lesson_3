import java.util.Arrays;
import java.util.Collection;


public class TestList<T extends Comparable<T>> {
    private T[] elements;
    private int size;

    private static final int SIZE = 10;


    public TestList() {
        this.elements = (T[]) new Comparable[SIZE];
        size = 0;
    }

    public void add(T element) {
        increaseSize(1);
        elements[size] = element;
        size++;
    }

    public void addAll(T[] elements) {
        if (elements == null || elements.length == 0) {
            return;
        }
        for (T element : elements) {
            add(element);
        }
    }

    public TestList(Collection<? extends T> collection) {
        this(); // Вызываем основной конструктор для инициализации массива
        for (T element : collection) { // Итерируемся по коллекции
            add(element); // Добавляем каждый элемент
        }
    }

    public void remove(int index) {
        validateIndex(index);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        if (size > SIZE) {
            decreaseSize(1);
        }
        size -= 1;
    }

    public void remove(T element) {
        remove(getIndex(element));

    }

    public T get(int index) {
        validateIndex(index);
        return elements[index];
    }


    public int getSize() {
        return size;
    }

    private int getIndex(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseSize(int size) {
        if (size + this.size > elements.length) {
            elements = Arrays.copyOf(elements, elements.length + size);
        }
    }

    private void decreaseSize(int size) {
        elements = Arrays.copyOf(elements, elements.length - size);
    }


    void sort() {
        boolean isSorted = false;
        T buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < elements.length-1; i++) {
                if (elements[i].compareTo(elements[i+1]) > 0) {
                    isSorted = false;

                    buf = elements[i];
                    elements[i] = elements[i+1];
                    elements[i+1] = buf;
                }
            }
        }
        System.out.println("Список отсортирован");
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }


}
