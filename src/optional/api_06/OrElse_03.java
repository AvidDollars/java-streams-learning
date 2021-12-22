package optional.api_06;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class OrElse_03 {
    public static void main(String[] args) {
        // Optional - orElse, orElseGet(Supplier),
        // orElseThrow, orElseThrow(Supplier)

        List<Integer> numberList = List.of(
                12, 5, 7, 4, 8, 55, 47, 50,
                77, 19, 5, 0, 4, 15, 22, 25
        );

        Predicate<Integer> divisibleBy13 = number -> number % 13 == 0 && number != 0;

        int number = numberList.stream()
                .filter(divisibleBy13)
                .findFirst()
                // if number divisible by 13 is not found
                .orElse(-1);

        // other options:
        //
        //      .orElseGet(OrElse_03::defaultValue);
        //      .orElseThrow(); → throws 'NoSuchElementException'
        //      .orElseThrow(() -> new Error("not found..."));

        // number; → -1
    }

    // or define 'Supplier' object
    static int defaultValue() {
        // some calculations can be done here
        return -1;
    }
}
