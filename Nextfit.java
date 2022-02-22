import java.util.Arrays;

//next fit implementation of bin packing algorithm

class NextFit{
    //declare variables
    private int binCapacity;
    private int[] items;
    private int[] binOccupancy;
    private int binCount;
    private long duration;
   
    private int numBins;
    
    //constructor
    public NextFit(int binCapacity, int[] items){
        this.binCapacity = binCapacity;
        this.items = items;
        binOccupancy = new int[items.length];
        numBins = items.length;

    }

    //method to insert all items into bins
    public void insertAllItems(int[] items){
        long start = System.nanoTime();
        int itemIndex = 0;
        int binIndex = 0;
       
        for(int i = 0; i < items.length; i++){
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


    //method to find number of bins used

    public String getNumBins() {
        return String.valueOf(binCount);
    }

    public String getDuration() {
        return  String.valueOf(duration);
    }




}  