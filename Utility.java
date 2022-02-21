import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Utility {

    // method for sorting
    public static int[] sort(int[] arr) {
        return Arrays.stream(arr).sorted().toArray();
    }
    
    // method for sorting in reverse order
    public static int[] sortReverse(int[] arr) {
        return Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).mapToInt(x -> x).toArray();
    }
    
    // method for finding max
    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // method for getting random array of predefined size and bound
    public static int[] getRandomArray(int n, int max) {
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(max);
        }
        return arr;
    }
    
    // method for getting random array copy
    public static int[] getArrayCopy(int[] arr) {
        int[] copy = new int[arr.length];
        
        for(int i=0; i<arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    // method for exporting to csv
    public static void exportToCSV(List<List<String>> info, List<String> header, String fileName) {
        
        String LINE_SEP = "\n";
        String COMMA_DELIM = ",";
        File csvFile = new File(fileName);

        try (FileWriter fileWriter = new FileWriter(csvFile)) {
            // writing header
            for (int i = 0; i < header.size(); i++) {
                fileWriter.write(header.get(i));
                if (i < header.size() - 1) {
                    fileWriter.write(COMMA_DELIM);
                }
            }
            fileWriter.write(LINE_SEP);
             
            // writing body
            for (int i = 0; i < info.size(); i++) {
                for (int j = 0; j < info.get(i).size(); j++) {

                    fileWriter.write(info.get(i).get(j));
                    if (j < info.get(i).size() - 1) {
                        fileWriter.write(COMMA_DELIM);
                    }
                }
                fileWriter.write(LINE_SEP); 
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
