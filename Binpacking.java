//declaring main class and calling the method
public class Binpacking {
    public static void main(String[] args) {
        //declaring variables
        int binCapacity = 6;
        int[] items = {5,2,6,3,4,1};
        
        //constructor
        Nextfit nextfit = new Nextfit(binCapacity, items);
        NextFitDecreasing nextfitDecreasing = new NextFitDecreasing(binCapacity, items);
        
        //method to insert all items into bins
        nextfit.insertAllItems(items);
        nextfitDecreasing.insertAllItems(items);
        
        //method to find number of bins used
        int numBins = nextfit.getNumBins();
        int numBinsDecreasing = nextfitDecreasing.getNumBins();

        
        //printing the number of bins used
        System.out.println("Number of bins used: " + numBins);
        System.out.println("Number of bins used: " + numBinsDecreasing);
    }

}