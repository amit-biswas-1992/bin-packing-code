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
        long start = System.nanoTime();
<<<<<<< HEAD
=======
        // long start = System.currentTimeMillis();
>>>>>>> cae08c024b5018d436a820a01643e18c2c818c06
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
        long end = System.nanoTime();
<<<<<<< HEAD
=======
        // long end = System.currentTimeMillis();
>>>>>>> cae08c024b5018d436a820a01643e18c2c818c06
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
