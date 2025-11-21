import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    private final Random random;
    private final int min;
    private final int max;

    public Randoms(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Минимальное значение не может быть больше максимального");
        }
        this.random = new Random();
        this.min = min;
        this.max = max;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RandomIterator();
    }

    // Внутренний класс-итератор (без record — обычный класс)
    private class RandomIterator implements Iterator<Integer> {

        // Конструктор по умолчанию — ничего не делает
        public RandomIterator() {
        }

        @Override
        public boolean hasNext() {
            return true; // бесконечная последовательность
        }

        @Override
        public Integer next() {
            // Генерация числа от min до max включительно
            return min + random.nextInt(max - min + 1);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() не поддерживается");
        }
    }
}