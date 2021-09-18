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
        String filePathName = "/home/olesya/IdeaProjects/LargeCSVTestTask/src/main/resources/smallTest.csv";
//        String filePathName = "/home/olesya/IdeaProjects/LargeCSVTestTask/src/main/resources/cancer.csv";
//        String filePathName = "/home/olesya/IdeaProjects/LargeCSVTestTask/src/main/resources/ratings.csv";
//        String filePathName = args[0];
//        int headerNumber = Integer.parseInt(args[1]);
        CSVProcessor processor = new CSVProcessor(filePathName, 3);
        processor.process();
        processor.printResult();
    }
}
