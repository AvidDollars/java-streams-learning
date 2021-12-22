package optional.api_06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class FindInFile_05 {
    static final String FILE_PATH = "src/optional/api_06/words";

    public static void main(String[] args) {

        // 'try-with-resources' → ensures that file will be closed
        // 'lines' method returns 'Stream' object
        try (Stream<String> lines = Files.lines(Paths.get(FILE_PATH))) {
            Optional<String> word = lines
                    .filter(w -> wordOfMinLengthN(w,10))
                    .findFirst(); // or .findAny()

            // word.orElse("not found"); → numberless

        } catch (IOException e) {
            System.out.printf("Error has occurred: %s", e);
        }
    }

    static boolean wordOfMinLengthN(String word, int minLength) {
        return word.length() >= minLength;
    }
}
