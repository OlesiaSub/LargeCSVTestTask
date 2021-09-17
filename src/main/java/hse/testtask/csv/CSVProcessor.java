package hse.testtask.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;

public class CSVProcessor {

    private static int headerNumber;
    private static final String delimiter = ",";
    private static String filePathName;
    private static final SortedSet<Double> items = new TreeSet<>();

    public CSVProcessor(String filePathName, int headerNumber) {
        CSVProcessor.filePathName = filePathName;
        CSVProcessor.headerNumber = headerNumber;
    }

    static void addItemToSet(Double newItem) {
        if (items.size() < 10) {
            items.add(newItem);
        } else {
            Double highest = items.last();
            if (newItem < highest) {
                items.remove(highest);
                items.add(newItem);
            }
        }
    }

    public void process() throws IOException {
        traverseLines();
        for (Double item : items) {
            System.out.println(item);
        }
    }

    private void traverseLines() throws IOException {
        FileReader fileReader = new FileReader(filePathName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String currentLine = bufferedReader.readLine();
        while ((currentLine = bufferedReader.readLine()) != null) {
            processLine(currentLine);
        }
    }

    private static void processLine(String line) {
        String[] lines = line.split(delimiter);
        String timeStringFormat = lines[headerNumber];
        Double time = Double.parseDouble(timeStringFormat);
        addItemToSet(time);
    }

}
