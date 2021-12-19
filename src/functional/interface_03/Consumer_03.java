package functional.interface_03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Consumer_03 {
    public static void main(String[] args) {
        // Consumer accepts single argument and returns no value
        // two methods:
        //      - void accept(T t)
        //      - default Consumer<T> andThen(Consumer<? super T> after)

        Consumer<Object> print = (Object object) -> System.out.println(object);
        print.accept("hello"); // hello

        Consumer<String> printTwo = System.out::println; // or method reference instead of lambda
        printTwo.accept("Lojza");

        // function that accepts Consumer as second argument
        printString("printString", null); // printString
        printString("printString", (string) -> System.out.println(string.toUpperCase())); // PRINTSTRING

        // andThen
        List<String> users = new ArrayList<>();
        Consumer<List<String>> updateList = list -> list.add("new user");
        Consumer<List<String>> showUsers = System.out::println;
        Consumer<List<String>> updateUsersAndPrintUpdatedList = updateList.andThen(showUsers);
        updateUsersAndPrintUpdatedList.accept(users);  // ["new user"]

        // print all numbers squared
        // forEach takes consumer as an argument
        List<Integer> numList = List.of(1, 2, 3, 4, 5);
        applyConsumerOnListElements(numList, num -> System.out.println(num * num));
        numList.forEach(System.out::print);

        // other Consumer interfaces:
        //      for primitives: IntConsumer, LongConsumer, DoubleConsumer
        //      accepts 2 arguments: BiConsumer
    }

    static void printString(String string, Consumer<String> displayOutput) {
        if (displayOutput != null) {
            displayOutput.accept(string);
        } else {
            System.out.println(string);
        }
    }

    static <T> void applyConsumerOnListElements(List<T> list, Consumer<T> consumer) {
        if (list != null) {
            for (T t : list) {
                consumer.accept(t);
            }
        }
    }
}
