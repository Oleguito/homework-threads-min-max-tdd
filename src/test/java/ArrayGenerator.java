import java.util.function.IntSupplier;

public class ArrayGenerator {

    public int[] generate(int size, IntSupplier intSupplier) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = intSupplier.getAsInt();
        }
        return array;
    }

}
