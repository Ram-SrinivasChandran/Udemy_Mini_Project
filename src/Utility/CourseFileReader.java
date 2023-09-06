package Utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * This CourseFileReader class is to read the file content and display it in the console
 */

public class CourseFileReader {
    /**
     * This read method has acces to the Java_course file
     * It will read the content from the file and Display it in the Console
     * @throws IOException
     */
    public void read() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Java_Course.txt"));
        Stream<String> lines = bufferedReader.lines();
        lines.forEach(System.out::println);
    }
}
