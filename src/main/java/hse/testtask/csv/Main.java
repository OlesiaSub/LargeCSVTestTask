package hse.testtask.csv;

import java.io.IOException;

public class Main {

    /**
     *
     * @param args
     * args[0] - path to the .csv file
     * args[1] - number of "timestamp" header
     *
     */
    public static void main(String[] args) throws IOException {
        String filePathName = args[0];
        int headerNumber = Integer.parseInt(args[1]);
        CSVProcessor processor = new CSVProcessor(filePathName, headerNumber);
        processor.process();
        processor.printResult();
    }
}
