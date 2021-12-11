import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortList_02 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "these", "strings", "has", "to",
                "be", "sorted", "based", "on",
                "its", "length"
        );

        List<String> sortedList = sortWithComparator(words);
        System.out.println(sortedList);

        List<String> sortedListTwo = sortWithStream(words);
        System.out.println(sortedListTwo);
    }

    // huh... quite verbose code
    public static List<String> sortWithComparator(List<String> list) {
        List<String> listToSort = new ArrayList<>(list);

        // Comparator is an Interface → 'compare' method has to be implemented
        Comparator<String> byStrLen = new Comparator<String>() {

            // length based sorting (alphabetical order sorting if the same length)
            @Override
            public int compare(String s1, String s2) {
                return (s1.length() == s2.length())
                        ? s1.compareTo(s2)
                        : s1.length() - s2.length();
            }
        };

        listToSort.sort(byStrLen);
        return listToSort;
    }

    // functional approach
    // short and expressive
    public static List<String> sortWithStream(List<String> list) {
        return list.stream()
                .sorted(Comparator
                        .comparing(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }
}
