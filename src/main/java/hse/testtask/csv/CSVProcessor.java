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
    private final SortedSet<String> values = new TreeSet<>((fstLine, sndLine) -> {
        Double fstTime = getTime(fstLine);
        Double sndTime = getTime(sndLine);
        if (fstTime < sndTime) return -1;
        else if (fstLine.equals(sndLine)) return 0;
        return 1;
    });

    public CSVProcessor(String filePathName, int headerNumber) {
        CSVProcessor.filePathName = filePathName;
        CSVProcessor.headerNumber = headerNumber;
    }

    private Double getTime(String line) {
        String[] lines = line.split(delimiter);
        String timeStringFormat = lines[headerNumber];
        return Double.parseDouble(timeStringFormat);
    }

    public SortedSet<String> getValues() {
        return values;
    }

    private void addItemToSet(String newItem) {
        Double current = getTime(newItem);
        if (values.size() < 10) {
            values.add(newItem);
        } else {
            Double highest = getTime(values.last());
            if (current < highest) {
                values.remove(values.last());
                values.add(newItem);
            }
        }
    }

    public void printResult() {
        for (String value : values) {
            System.out.println(value);
        }
    }

    public void process() throws IOException {
        FileReader fileReader = new FileReader(filePathName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String currentLine;
        bufferedReader.readLine();
        while ((currentLine = bufferedReader.readLine()) != null) {
            addItemToSet(currentLine);
        }
    }

}
