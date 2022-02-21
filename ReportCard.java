import java.util.ArrayList;
import java.util.List;

public class ReportCard {
    private int upperLimit = 10_000;

    public void generateReport() {

        List<String> fileHeader = List.of("Bin Capacity", "Total Items", "Bins Required", "Execution Time");

        List<List<String>> firstFitInfo = new ArrayList<>();
        List<List<String>> firstFitDecreasingInfo = new ArrayList<>();
        List<List<String>> nextFitInfo = new ArrayList<>();

        String firstFitfileName = "FF_Report.csv";
        String firstFitDecreasingfileName = "FFD_Report.csv";
        String nextFitfileName = "NF_Report.csv";

        // List<String> finalheader = List.of("Bin Capacity", "Total Items", "Bins Required (FF)", "Execution Time(FF)", "Bins Required (FFD)", "Execution Time(FFD)", "Bins Required (NF)", "Execution Time(NF)");
        // List<String> finalResult = new ArrayList<>();
        // List<List<String>> finalInfo = new ArrayList<>();
        // String finalFileName = "FINAL_Report.csv";

        for (int binCapacity = 10; binCapacity <= 100; binCapacity += 10) {
            for(int itemCount = 10; itemCount <= upperLimit; itemCount = itemCount * 10) {

                int[] itemArray = Utility.getRandomArray(itemCount, binCapacity);

                int[] firstFitCopy = Utility.getArrayCopy(itemArray);
                int[] firstFitDecreasingCopy = Utility.getArrayCopy(itemArray);
                int[] nextFitCopy = Utility.getArrayCopy(itemArray);

                FirstFit firstFit = new FirstFit(firstFitCopy, binCapacity);
                firstFit.packItems();
                firstFitInfo.add(firstFit.getResult());

                FirstFitDecreasing firstFitDecreasing = new FirstFitDecreasing(firstFitDecreasingCopy, binCapacity);
                firstFitDecreasing.packItems();
                firstFitDecreasingInfo.add(firstFitDecreasing.getResult());

                NextFit2 nextFit = new NextFit2(nextFitCopy, binCapacity);
                nextFit.packItems();
                nextFitInfo.add(nextFit.getResult());

                // finalResult.add(String.valueOf(binCapacity));
                // finalResult.add(String.valueOf(itemCount));
                // finalResult.addAll(firstFit.getResult());
                // finalResult.addAll(firstFitDecreasing.getResult());
                // finalResult.addAll(nextFit.getResult());
                // finalInfo.add(finalResult);
            }
        }
        Utility.exportToCSV(firstFitInfo, fileHeader, firstFitfileName);
        Utility.exportToCSV(firstFitDecreasingInfo, fileHeader, firstFitDecreasingfileName);
        Utility.exportToCSV(nextFitInfo, fileHeader, nextFitfileName);

        // Utility.exportToCSV(finalInfo, header, finalFileName);
    }

    public static void main(String[] args) {
        ReportCard reportCard = new ReportCard();
        reportCard.generateReport();
    }
}
