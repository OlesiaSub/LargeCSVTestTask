import hse.testtask.csv.CSVProcessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class LargeCSVTest {

    @Test
    public void testEmptyFile() throws IOException {
        CSVProcessor processor = new CSVProcessor("/home/olesya/IdeaProjects/LargeCSVTestTask/src/test/resources/emptyTest.csv", 3);
        processor.process();
        Assertions.assertEquals(processor.getValues(), new TreeSet<>());
    }

    @Test
    public void testStandardFile() throws IOException {
        List<String> values = Arrays
                .asList("14, 2.41, 0.058, 22",
                        "10, 4.41, 0.238, 32",
                        "1, 0.00, 0.050, 50",
                        "7, 2.33, 0.193, 76",
                        "4, 2.47, 0.116, 108",
                        "5, 1.96, 0.142, 138",
                        "6, 2.45, 0.166, 158",
                        "11, 2.93, 0.193, 174",
                        "3, 0.98, 0.087, 180",
                        "8, 3.43, 0.204, 192");
        CSVProcessor processor = new CSVProcessor("/home/olesya/IdeaProjects/LargeCSVTestTask/src/test/resources/standardTest.csv", 3);
        processor.process();
        Assertions.assertEquals(getCheckList(values), getCheckList(new ArrayList<>(processor.getValues())));
    }

    @Test
    public void testEqualMarks() throws IOException {
        List<String> values = Arrays
                .asList("14, 2.41, 0.058, 22",
                        "10, 4.41, 0.238, 32",
                        "1, 0.00, 0.050, 50",
                        "7, 2.33, 0.193, 50",
                        "4, 2.47, 0.116, 108",
                        "5, 1.96, 0.142, 138",
                        "6, 2.45, 0.166, 158",
                        "11, 2.93, 0.193, 174",
                        "3, 0.98, 0.087, 180",
                        "8, 3.43, 0.204, 180");
        CSVProcessor processor = new CSVProcessor("/home/olesya/IdeaProjects/LargeCSVTestTask/src/test/resources/equalTest.csv", 3);
        processor.process();
        Assertions.assertEquals(getCheckList(values), getCheckList(new ArrayList<>(processor.getValues())));
    }

    @Test
    public void testSmallFile() throws IOException {
        List<String> values = Arrays
                .asList("0.00, 0.050, 50",
                        "2.47, 0.116, 108",
                        "1.96, 0.142, 138",
                        "2.45, 0.166, 158",
                        "0.98, 0.087, 180",
                        "3.49, 0.066, 266");
        CSVProcessor processor = new CSVProcessor("/home/olesya/IdeaProjects/LargeCSVTestTask/src/test/resources/smallTest.csv", 2);
        processor.process();
        Assertions.assertEquals(getCheckList(values), getCheckList(new ArrayList<>(processor.getValues())));
    }

    @Test
    public void testAllEqual() throws IOException {
        List<String> values = Arrays
                .asList( " 1, 0.00, 0.050, 220",
                " 2, 3.49, 0.066, 220",
                " 3, 0.98, 0.087, 220",
                " 4, 2.47, 0.116, 220",
                " 5, 1.96, 0.142, 220",
                " 6, 2.45, 0.166, 220",
                " 7, 2.33, 0.193, 220",
                " 8, 3.43, 0.204, 220",
                " 9, 3.92, 0.226, 220",
                "10, 4.41, 0.238, 220");
        CSVProcessor processor = new CSVProcessor("/home/olesya/IdeaProjects/LargeCSVTestTask/src/test/resources/allEqualTest.csv", 3);
        processor.process();
        Assertions.assertEquals(getCheckList(values), getCheckList(new ArrayList<>(processor.getValues())));
    }

    private List<String> getCheckList(List<String> values) {
        return values.stream().map(s -> s.replaceAll("\\s+", "")).collect(Collectors.toList());
    }

}
