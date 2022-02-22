import java.util.List;

public class WorstFit {
    private int[] items;
    private int binCapacity;
    private int binCount;
    private int[] binArray;
    private long duration;

    public WorstFit(int[] items, int binCapacity) {
        this.items = items;
        this.binCapacity = binCapacity;
        this.binCount = 0;
        this.binArray = new int[items.length]; // default 0
    }

    public int packItems() {
        long start = System.nanoTime();
        for (int item : items) {
            int k;
            int worst=0;   // the best supposed to be minimum
            int worst_bucket=0;
            // boolean inserted = false;
            for (k = 0; k < binCount; k++) {
                int emptyStorage = binCapacity - binArray[k]; // empty storage of each bin

                if(worst < emptyStorage & emptyStorage >= item){
                    worst=emptyStorage;
                    worst_bucket=k;
                }

            }
            if (worst > 0) {
                binArray[worst_bucket] += item;
                // inserted = true;
                break;
            }


            else { // enter only if new bin needed
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
