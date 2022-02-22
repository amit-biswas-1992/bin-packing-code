import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReportCard {
    private int upperLimit = 1000000;

    public void generateReport() {


        List<List<String>> executionTimeInfos = new ArrayList<>();
        List<List<String>> requiredBinInfos = new ArrayList<>();

        String executionTimeFile = "ExecutionTimeReport.csv";
        String requiredBinFileName = "RequiredBinReport.csv";

        int binCapacity = 10;

        for(int itemCount = 10; itemCount <= upperLimit; itemCount = itemCount * 10) {

                int[] itemArray = Utility.getRandomArray(itemCount, binCapacity);

            

                //first fit section
                int[] firstFitCopy = Utility.getArrayCopy(itemArray);
                FirstFit firstFit = new FirstFit(firstFitCopy, binCapacity);
                firstFit.packItems();
                
                //first fit decreasing section
                int[] firstFitDecreasingCopy = Utility.getArrayCopy(itemArray);
                FirstFitDecreasing firstFitDecreasing = new FirstFitDecreasing(firstFitDecreasingCopy, binCapacity);
                firstFitDecreasing.packItems();

                //next fit section
                int[] nextFitCopy = Utility.getArrayCopy(itemArray);
                NextFit nextFit = new NextFit(binCapacity, nextFitCopy);
                nextFit.insertAllItems(nextFitCopy);

                //next fit decreasing section
                int[] nextFitDecreasingCopy = Utility.getArrayCopy(itemArray);
                NextFitDecreasing nextFitDecreasing = new NextFitDecreasing(binCapacity, nextFitDecreasingCopy);
                nextFitDecreasing.insertAllItems(nextFitDecreasingCopy);

                //best fit section
                int[] bestFitCopy = Utility.getArrayCopy(itemArray);
                BestFit bestFit = new BestFit(bestFitCopy, binCapacity);
                bestFit.packItems();

                //worst fit  section
                int[] worstFitCopy = Utility.getArrayCopy(itemArray);
                WorstFit worstFit = new WorstFit(worstFitCopy, binCapacity);
                worstFit.packItems();


                //add to list
                //List<String> executionInfo = List.of(String.valueOf(binCapacity), firstFit.getDuration(), firstFitDecreasing.getDuration(), nextFit.getDuration(), nextFitDecreasing.getDuration(), bestFit.getDuration(), worstFit.getDuration());
                //executionTimeInfos.add(executionInfo );

                //execution 
                List<String> executionInfo = new ArrayList<>();
                String[] values = {String.valueOf(itemCount), firstFit.getDuration(), firstFitDecreasing.getDuration(), nextFit.getDuration(), nextFitDecreasing.getDuration(), bestFit.getDuration(), worstFit.getDuration()};

                executionInfo.addAll(Arrays.asList(values));
                executionTimeInfos.add(executionInfo);

                //required bin
                List<String> requiredBinInfo = new ArrayList<>();
                String[] values2 =  {String.valueOf(itemCount), firstFit.getNumBins(), firstFitDecreasing.getNumBins(), nextFit.getNumBins(), nextFitDecreasing.getNumBins(), bestFit.getNumBins(), worstFit.getNumBins()};
                requiredBinInfo.addAll(Arrays.asList(values2));
                requiredBinInfos.add(requiredBinInfo );

                
            }
        
        Utility.exportToCSV(executionTimeInfos, executionTimeFile);
        Utility.exportToCSV(requiredBinInfos, requiredBinFileName);
        

    }

    public static void main(String[] args) {
        ReportCard reportCard = new ReportCard();
        reportCard.generateReport();
    }
}
