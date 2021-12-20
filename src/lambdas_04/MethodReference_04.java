package lambdas_04;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference_04 {
    public static void main(String[] args) {

        // we can use lambdas
        Function<String, String> capsLock = string -> string.toUpperCase();

        // or method reference (introduced in Java 8)
        Function<String, String> capsLockTwo = String::toUpperCase;

        // referencing static method → Class::staticMethod
        List<Integer> listOfInts = List.of(1, 2, 3, 4, 5);
        Function<List<Integer>, Integer> sumNums = MethodReference_04::sum;
        sumNums.apply(listOfInts); // 15

        // referencing class constructor → Class::new
        Supplier<Test> testObject = Test::new;
        Test test = testObject.get(); // Test{a=5}

        // referencing object method → Class::objectMethod
        Function<Test, Integer> square = Test::square;
        square.apply(test); // 25

        // sorting an array → by using 'sort' static method from Arrays class
        // 'sort' 1st argument → an array, 2nd argument → Comparator
        // e.g. lexicographic case-insensitive string sorting:
        String[] names = {"Jack", "Peter", "Martin", "Lojza", "Abraham", "Jane", "Xaver"};
        Arrays.sort(names, String::compareToIgnoreCase); // [Abraham, Jack, Jane, ... ]

        // e.g. print with 'forEach' method
        Arrays.asList(1, 2, 3, 4, 5).forEach(System.out::print); // 12345
    }

    static int sum(List<Integer> list) {
        int sum = 0;
        for (int num: list) {
            sum += num;
        }
        return sum;
    }
}

class Test {
    int a;

    Test() {
        this.a = 5;
    }

    int square() {
        return a * a;
    }

    @Override
    public String toString() {
        return "Test{" +
                "a=" + a +
                '}';
    }
}
