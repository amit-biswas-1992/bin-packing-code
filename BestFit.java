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
        long start = System.nanoTime();
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
            if (best <= binCapacity) {
                binArray[best_bucket] += item;
                // inserted = true;
             //   break;
            }
            else{ // enter only if new bin needed
                binArray[k] += item;
                binCount++; // startying another fresh bin
            }
            
        }
        long end = System.nanoTime();
        duration = end - start;
        return binCount;
    }

    public String getNumBins() {
        return String.valueOf(binCount);
    }

    public String getDuration() {
        return  String.valueOf(duration);
    }
}
