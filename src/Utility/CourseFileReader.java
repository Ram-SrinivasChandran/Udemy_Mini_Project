package Utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class CourseFileReader {
    public void read() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Java_Course.txt"));
        Stream<String> lines = bufferedReader.lines();
        lines.forEach(System.out::println);
    }
}
