package test;


import main.Randoms;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RandomsTest {

    @Test
    void testGeneratedNumbersAreInInclusiveRange() {
        Randoms randoms = new Randoms(90, 100);

        for (int i = 0; i < 1000; i++) {
            Integer num = randoms.iterator().next();
            assertTrue(num >= 90 && num <= 100,
                    () -> "Число " + num + " вне диапазона [90, 100]");
        }
    }

    @Test
    void testCanGenerateMinAndMaxValues() {
        Randoms randoms = new Randoms(90, 100);

        Set<Integer> generated = new HashSet<>();

        // Генерируем достаточно много, чтобы с высокой вероятностью поймать границы
        for (int i = 0; i < 50_000; i++) {
            generated.add(randoms.iterator().next());
            if (generated.contains(90) && generated.contains(100)) {
                break;
            }
        }

        assertTrue(generated.contains(90), "Должно быть возможно сгенерировать минимальное значение (90)");
        assertTrue(generated.contains(100), "Должно быть возможно сгенерировать максимальное значение (100)");
    }

    @Test
    void testMinEqualsMax_ReturnsOnlyThatValue() {
        Randoms randoms = new Randoms(42, 42);

        Iterator<Integer> iterator = randoms.iterator();
        for (int i = 0; i < 1000; i++) {
            assertEquals(42, iterator.next().intValue(),
                    "При min == max должно всегда возвращаться одно и то же число");
        }
    }

    @Test
    void testMinGreaterThanMax_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Randoms(100, 90);
        }, "Должно бросаться исключение, если min > max");
    }


}