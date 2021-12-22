package reduction_07;

import java.util.Arrays;
import java.util.List;

public class MatchMethods_02 {
    public static void main(String[] args) {
        // methods of interest:
        //      anyMatch → if at least one match
        //      allMatch → if match for all elements
        //      noneMatch → if there is no match → !allMatch
        //
        // methods mentioned above take predicate as an input and return boolean
        // short-circuit method evaluation

        List<String> wordsList = Arrays.asList(
                "hello", "world", "there", "are", "just",
                "some", "randomly", "selected", "words"
        );

        boolean allLongerThan3 = wordsList.stream()
                .allMatch(word -> word.length() > 3);
        // allLongerThan3; → false

        boolean allNoLongerThan10 = wordsList.stream()
                .noneMatch(word -> word.length() > 10);
        // allNoLongerThan10; → true
    }
}
