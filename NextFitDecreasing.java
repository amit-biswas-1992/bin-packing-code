import java.util.Arrays;

//next fit implementation of bin packing algorithm

class NextFitDecreasing{
    //declare variables
    private int binCapacity;
    private int[] items;
    private int[] binOccupancy;
   private int numBins;
   private int binCount;
    private long duration;
    
    //constructor
    public NextFitDecreasing(int binCapacity, int[] items){
        this.binCapacity = binCapacity;
        this.items = items;
        this.binOccupancy = new int[items.length];
        this.numBins = items.length;
    }

    //method to insert all items into bins
    public void insertAllItems(int[] items){
        long start = System.nanoTime();
        //count sort items in decreasing order
        int[] sortedItems = CountingSort.countSortDescending(items);

        //print sorted items
        //System.out.println("Sorted items: " + Arrays.toString(sortedItems));
        
        
        int itemIndex = 0;
        int binIndex = 0;

        for(int i = 0; i < sortedItems.length; i++){
            if(binOccupancy[binIndex] + items[i] <= binCapacity){
                binOccupancy[binIndex] += items[i];
                itemIndex++;
            }
            else{
                binIndex++;
                binOccupancy[binIndex] += items[i];
                itemIndex++;
            }
        }
        binCount = binIndex +1;
        long end = System.nanoTime();
        duration = end - start;
        
    }

    //method for counting sort items in decreasing order


    public String getNumBins() {
        return String.valueOf(binCount);
    }

    public String getDuration() {
        return  String.valueOf(duration);
    }




}  