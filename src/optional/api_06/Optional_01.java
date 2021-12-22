package optional.api_06;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Optional_01 {
    public static void main(String[] args) {
        // 'Optional' class → introduced in Java 8
        // Optional<T> → behaves like container object
        // when used appropriately indicates the absence of a value
        // avoid using it in Collections (e.g. List<Optional<T>>)

        String personName = "Peter";

        // argument passed to 'of' method can not be null
        Optional<String> name = Optional.of(personName);

        name.get(); // getting value
        name.isEmpty(); // if value == null
        name.isPresent(); // if value != null

        Optional<String> mysteryBox = Optional.empty();
        mysteryBox.orElse("was empty..."); // was empty...

        Optional<String> canBeNull = Optional.ofNullable(null);
        canBeNull.orElse("was null..."); // was null...

        // e.g. find all 4-digit numbers
        List<String> numList = List.of("246", "7254", "hello", "2590", "12345", "4444");
        numList.stream()
                .forEach(num -> System.out.println(validNumber(num).orElse("invalid")));
        // forEach → invalid, 7254, invalid, 2590, invalid, 4444
    }

    static Optional<String> validNumber(String number) {
        // 4-digit number
        Pattern pattern = Pattern.compile("^\\d{4}$");
        Matcher matcher = pattern.matcher(number);

        return matcher.find()
                // returns string back if there is a match
                ? Optional.of(matcher.group())
                // returns empty Optional is there is no match
                : Optional.empty();
    }
}
