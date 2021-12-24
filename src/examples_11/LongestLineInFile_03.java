package examples_11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

public class LongestLineInFile_03 {
    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Paths.get("src/examples_11/text"))) {
            String longestLine = lines
                    .max(Comparator.comparing(String::length))
                    .orElse("");
            // longestLine; → and this is fourth line which is also the longest one

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
