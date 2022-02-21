import java.util.Arrays;

//next fit implementation of bin packing algorithm

class NextfitDecreasing{
    //declare variables
    private int binCapacity;
    private int[] items;
    private int[] binOccupancy;
   private int numBins;
    
    //constructor
    public NextfitDecreasing(int binCapacity, int[] items){
        this.binCapacity = binCapacity;
        this.items = items;
        this.binOccupancy = new int[items.length];
        this.numBins = items.length;
    }

    //method to insert all items into bins
    public void insertAllItems(int[] items){
        //sort items in decreasing order
        Arrays.sort(items);
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
        
    }


    //method to find number of bins used
    public int getNumBins(){
        //counting number of bins used using lamda function
        return (int) Arrays.stream(binOccupancy).filter(x -> x > 0).count();
        
    }




}  