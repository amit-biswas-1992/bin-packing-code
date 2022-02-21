
public class FirstFitTest {
       
    public static void main(String[] args) {
        // int[] items = {4, 9, 2, 3, 5, 7, 8, 1, 6, 10};
        // int binCapacity = 10;

        int max = 100000;
        int count = 50000;
        int[] items = Utility.getRandomArray(count, max);
        int binCapacity = max;

        // testing next fit
        int[] nextFitCopy = Utility.getArrayCopy(items);
        NextFit2 nextFit = new NextFit2(nextFitCopy, binCapacity);
        nextFit.packItems();
        nextFit.printResult();
        
        // testing first fit
        int[] firstFitCopy = Utility.getArrayCopy(items);
        FirstFit firstFit = new FirstFit(firstFitCopy, binCapacity);
        firstFit.packItems();
        firstFit.printResult();
        
        // testing first fit decreasing
        int[] firstFitDecreasingCopy = Utility.getArrayCopy(items);
        FirstFitDecreasing firstFitDdecreasing = new FirstFitDecreasing(firstFitDecreasingCopy, binCapacity);
        firstFitDdecreasing.packItems();
        firstFitDdecreasing.printResult();
        // firstFitDdecreasing.exportResult();

    }
}
