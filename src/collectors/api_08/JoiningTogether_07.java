package collectors.api_08;

import java.util.Arrays;
import java.util.stream.Collectors;

public class JoiningTogether_07 {
    public static void main(String[] args) {
        String[] wordArray = {
                "Hello", "World", "these", "are", "just", "some",
                "randomly", "picked", "words", "to", "play", "with",
                "while", "learning", "Java", "streams"
        };

        String fourCharactersWordsJoined = Arrays.stream(wordArray)
                .filter(word -> word.length() == 4)
                // 'joining' has two other overloaded variants:
                // - joining(delimiter) / joining()
                .collect(Collectors.joining(",", "-", "-"));

        // fourCharactersWordsJoined; → -just,some,play,with,Java-
    }

}
