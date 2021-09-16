package hse.testtask.csv;

import java.io.IOException;

public class Main {

    /**
     *
     * @param args
     * args[0] - path to the .csv file
     *
     */
    public static void main(String[] args) throws IOException {
//        String filePathName = "/home/olesya/IdeaProjects/LargeCSVTestTask/src/main/resources/hooke.csv";
//        String filePathName = "/home/olesya/IdeaProjects/LargeCSVTestTask/src/main/resources/cancer.csv";
        String filePathName = "/home/olesya/IdeaProjects/LargeCSVTestTask/src/main/resources/ratings.csv";
//        String filePathName = args[0];
//        String delimiter = args[1];
        CSVProcessor processor = new CSVProcessor(filePathName);
        processor.process();
    }
}
