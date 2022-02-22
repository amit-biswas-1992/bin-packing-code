import java.util.List;

public class BestFit {
    private int[] items;
    private int binCapacity;
    private int binCount;
    private int[] binArray;
    private long duration;

    public BestFit(int[] items, int binCapacity) {
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
            int best=binCapacity+1;   // the best supposed to be minimum
            int best_bucket=0;
            // boolean inserted = false;
            for (k = 0; k < binCount; k++) {
                int emptyStorage = binCapacity - binArray[k]; // empty storage of each bin

                if(best > emptyStorage & emptyStorage >= item){
                    best=emptyStorage;
                    best_bucket=k;
                }

            }
            if (best < binCapacity) {
                binArray[best_bucket] += item;
                // inserted = true;
         
            }


            else { // enter only if new bin needed
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
