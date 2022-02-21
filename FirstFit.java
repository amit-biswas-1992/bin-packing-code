import java.util.List;

public class FirstFit {
    private int[] items;
    private int binCapacity;
    private int binCount;
    private int[] binArray;
    private long duration;

    public FirstFit(int[] items, int binCapacity) {
        this.items = items;
        this.binCapacity = binCapacity;
        this.binCount = 0;
        this.binArray = new int[items.length]; // default 0
    }

    public int packItems() {
        // long start = System.nanoTime();
        long start = System.currentTimeMillis();
        for (int item : items) {
            int k;
            // boolean inserted = false;
            for (k = 0; k < binCount; k++) {
                int emptyStorage = binCapacity - binArray[k]; // empty storage of each bin
                if (item <= emptyStorage) {
                    binArray[k] += item;
                    // inserted = true;
                    break;
                }
            }
            
            if( k == binCount) { // enter only if new bin needed
                binArray[k] += item;
                binCount++; // startying another fresh bin
            }
        }
        // long end = System.nanoTime();
        long end = System.currentTimeMillis();
        duration = end - start;
        return binCount;
    }

    public void printResult() {
        System.out.println("[ Algorithm: First Fit ]");
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
