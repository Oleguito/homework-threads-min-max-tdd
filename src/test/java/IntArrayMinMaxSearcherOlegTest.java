import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntArrayMinMaxSearcherOlegTest {
    
    private ArrayGenerator arrayGenerator;
    private Random random;
    
    @BeforeEach
    void setUp() {
        arrayGenerator = new ArrayGenerator();
        random = new Random();
    }
    @Test
    void
    array_of_1000_between_1_and_10() {
        int[] array = arrayGenerator.generate(1001,
                () -> random.nextInt(1, 11));
        IntArrayMinMaxSearcherOleg searcher = new IntArrayMinMaxSearcherOleg(array);
        
        assertEquals(1, searcher.findMin());
        assertEquals(10, searcher.findMax());
    }
    @Test
    void
    array_of_1x1_of_1() {
        int[] array = arrayGenerator.generate(1,
                () -> 1);
        IntArrayMinMaxSearcherOleg searcher = new IntArrayMinMaxSearcherOleg(array);

        assertEquals(1, searcher.findMin());
        assertEquals(1, searcher.findMax());
    }

    @Test
    void
    array_of_1x2_of_1_2() {
        int[] array = new int[] {1, 2};
        IntArrayMinMaxSearcherOleg searcher = new IntArrayMinMaxSearcherOleg(array);

        assertEquals(searcher.findMin(), 1);
        assertEquals(searcher.findMax(), 2);
    }

    @Test
    void
    array_of_1x1000_of_1_2() {
        int[] array = arrayGenerator.generate(1000, () -> 1);
        array[0] = 2;
        IntArrayMinMaxSearcherOleg searcher = new IntArrayMinMaxSearcherOleg(array);

        assertEquals(searcher.findMin(), 1);
        assertEquals(searcher.findMax(), 2);
    }

    @Test
    void
    array_of_1x1000_000_of_1_2() {
        int[] array = arrayGenerator.generate(1_000_000, () -> 1);
        array[0] = 2;
        IntArrayMinMaxSearcherOleg searcher = new IntArrayMinMaxSearcherOleg(array);

        assertEquals(searcher.findMin(), 1);
        assertEquals(searcher.findMax(), 2);
    }

    @Test
    void
    array_of_1x2000_000_000_of_1_2() {
        int[] array = arrayGenerator.generate(2_000_000_000, () -> 1);
        array[0] = 2;
        IntArrayMinMaxSearcherOleg searcher = new IntArrayMinMaxSearcherOleg(array);

        assertEquals(searcher.findMin(), 1);
        assertEquals(searcher.findMax(), 2);
    }
}
