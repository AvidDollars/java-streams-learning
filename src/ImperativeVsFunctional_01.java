import java.util.*;
import java.util.stream.Collectors;

public class ImperativeVsFunctional_01 {
    public static void main(String[] args) {

        // let's split the words into separate fractions by its length
        List<String> words = List.of(
                "hello", "world", "this", "shows", "you",
                "the", "difference", "between", "verbose",
                "declarative", "approach", "and", "functional",
                "the", "functional", "one");

        // two approaches - the first is imperative, the second one is declarative
        declarativeApproach(words);
        functionalApproach(words);
    }

    // verbose... at first glance, it is not obvious what the code is doing
    public static void declarativeApproach(List<String> words) {
        Map<Integer, List<String>> wordsByLen = new HashMap<>();

        for (String word: words) {
            List<String> sameLenArr = null;
            Integer wordLen = word.length();

            if (wordsByLen.get(wordLen) == null) {
                sameLenArr = new ArrayList<>();
                wordsByLen.put(wordLen, sameLenArr);
            } else {
                sameLenArr = wordsByLen.get(wordLen);
            }

            sameLenArr.add(word);
        }

        System.out.println(wordsByLen);
    }

    // easy to understand, the code itself implies what we want to accomplish
    // short and clear... concise
    public static void functionalApproach(List<String> words) {
        Map<Integer, List<String>> wordsByLen = words.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(wordsByLen);
    }
}
