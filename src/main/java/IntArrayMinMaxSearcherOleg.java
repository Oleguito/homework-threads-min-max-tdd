import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MyThread extends Thread {
    
    private final int[] array;
    private final int to;
    private final int from;
    private int MIN = Integer.MAX_VALUE;
    private int MAX = Integer.MIN_VALUE;
    
    public MyThread(int[] array, int from, int to) {
        this.array = array;
        this.from = from;
        this.to = to;
    }
    
    public int getMIN() {
        return this.MIN;
    }
    
    public int getMAX() {
        return this.MAX;
    }
    
    @Override
    public void run() {
        for (int i = from; i < to; i++) {
            if(array[i] < MIN) {
                MIN = array[i];
            }
            if(array[i] > MAX) {
                MAX = array[i];
            }
        }
    }
}

public class IntArrayMinMaxSearcherOleg {
    
    private volatile int min = Integer.MAX_VALUE;
    private volatile int max = Integer.MIN_VALUE;
    
    public IntArrayMinMaxSearcherOleg(int[] array) {
        
        int size = array.length;
        
        if(size < 1000) {
            min = Arrays.stream(array).parallel().min().getAsInt();
            max = Arrays.stream(array).parallel().max().getAsInt();
            return;
        }
        
        int n = 12;
        int chunkSize = size / n;
        int remaining = size - chunkSize * n;
        
        List <MyThread> myThreads = new ArrayList<MyThread> ();
        for (int i = 0; i < n - 1; i++) {
            myThreads.add(new MyThread(
                    array,
                    i * chunkSize,
                    (i + 1) * chunkSize ));
        }
        
        myThreads.forEach(e -> e.start());
        myThreads.forEach(e -> {
            try { e.join(); } catch (InterruptedException ex)
            { throw new RuntimeException(ex); }
        });
        myThreads.forEach(e -> {
            if(e.getMIN() < min) { min = e.getMIN(); }
            if(e.getMAX() > max) { max = e.getMAX(); }
        });
        
        for (int i = chunkSize * n; i < size; i++) {
            if(array[i] < min) { min = array[i]; }
            if(array[i] > max) { max = array[i]; }
        }
        
    }
    
    public int findMin() {
        return min;
    }
    
    public int findMax() {
        return max;
    }
}
