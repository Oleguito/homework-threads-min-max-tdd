import java.util.Arrays;

public class IntArrayMinMaxSearcherStream {
    
    private int min;
    private int max;
    
    public IntArrayMinMaxSearcherStream(int[] array) {
        
        min = Arrays.stream(array).parallel().min().getAsInt();
        max = Arrays.stream(array).parallel().max().getAsInt();
    
    }
    
    public int findMin() {
        return min;
    }
    
    public int findMax() {
        return max;
    }
}
