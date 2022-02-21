import java.util.List;

public class NextFit2 {
    private int[] items;
    private int binCapacity;
    private int binCount;
    private long duration;
    public NextFit2(int[] items, int binCapacity) {
        this.items = items;
        this.binCapacity = binCapacity;
        this.binCount = 0;
    }

    public int packItems() {
        long start =System.nanoTime();
        // long start = System.currentTimeMillis();
        binCount++; // starting with first bin
        int emptyStorage = binCapacity; // initially first bin is fully empty
        for (int item : items) {
            if (item <= emptyStorage) {
                emptyStorage -= item;
            } else {
                binCount++; // startying another fresh bin
                emptyStorage = binCapacity; // with full empty bin
                emptyStorage -= item;
            }
        }
        long end = System.nanoTime();
        // long end = System.currentTimeMillis();
        duration = end - start;
        return binCount;
    }

    public void printResult() {
        System.out.println("[ Algorithm: Next Fit ]");
        // System.out.println("Item Array: " + Arrays.toString(items));
        System.out.printf("Bin Capacity = %d\n", binCapacity);
        System.out.printf("Required Bins = %d\n", binCount);
        System.out.printf("Execution Time = %d ns\n", duration);
        // System.out.printf("Execution Time = %d ms\n", duration);
        System.out.println();
    }
    
    public List<String> getResult() {
        String capacity = String.valueOf(binCapacity);
        String itemCount = String.valueOf(items.length);
        String requiredBins = String.valueOf(binCount);
        String executingTime = String.valueOf(duration);

        // return List.of(requiredBins, executingTime);
        return List.of(capacity, itemCount, requiredBins, executingTime);
    }
}
