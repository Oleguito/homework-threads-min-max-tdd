import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntArrayMinMaxSearcherStreamTest {
    
    private ArrayGenerator arrayGenerator;
    private Random random;
    
    @BeforeEach
    void setUp() {
        arrayGenerator = new ArrayGenerator();
        random = new Random();
    }
    
    @Test
    void
    array_of_1x1_of_1() {
        int[] array = arrayGenerator.generate(1,
                () -> 1);
        IntArrayMinMaxSearcherStream searcher = new IntArrayMinMaxSearcherStream(array);
        
        assertEquals(searcher.findMin(), 1);
        assertEquals(searcher.findMax(), 1);
    }
    
    @Test
    void
    array_of_1x2_of_1_2() {
        int[] array = new int[] {1, 2};
        IntArrayMinMaxSearcherStream searcher = new IntArrayMinMaxSearcherStream(array);
        
        assertEquals(searcher.findMin(), 1);
        assertEquals(searcher.findMax(), 2);
    }
    
    @Test
    void
    array_of_1x1000_of_1_2() {
        int[] array = arrayGenerator.generate(1000, () -> 1);
        array[0] = 2;
        IntArrayMinMaxSearcherStream searcher = new IntArrayMinMaxSearcherStream(array);
        
        assertEquals(searcher.findMin(), 1);
        assertEquals(searcher.findMax(), 2);
    }
    
    @Test
    void
    array_of_1x1000_000_of_1_2() {
        int[] array = arrayGenerator.generate(1_000_000, () -> 1);
        array[0] = 2;
        IntArrayMinMaxSearcherStream searcher = new IntArrayMinMaxSearcherStream(array);
        
        assertEquals(searcher.findMin(), 1);
        assertEquals(searcher.findMax(), 2);
    }
    
    @Test
    void
    array_of_1x2000_000_000_of_1_2() {
        int[] array = arrayGenerator.generate(2_000_000_000, () -> 1);
        array[0] = 2;
        IntArrayMinMaxSearcherStream searcher = new IntArrayMinMaxSearcherStream(array);
        
        assertEquals(searcher.findMin(), 1);
        assertEquals(searcher.findMax(), 2);
    }
}
