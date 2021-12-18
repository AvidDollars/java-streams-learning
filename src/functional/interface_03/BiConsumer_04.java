package functional.interface_03;

import java.util.Map;
public class BiConsumer_04 {
    public static void main(String[] args) {
        // one abstract method → void accept(T t, U u)
        // eg.: for iterating over HashMap
        Map<Integer, String> dictionary = Map.of(
                1, "one",
                2, "two",
                3, "three"
        );

        // normal way of iterating over map:
        for (Map.Entry<Integer, String> entry: dictionary.entrySet()) {
            System.out.printf("key=%s, value=%s\n", entry.getKey(), entry.getValue());
        }

        // forEach method in Map interface takes BiConsumer as an argument
        dictionary.forEach((key, value) -> System.out.printf("key=%s, value=%s\n", key, value));
    }
}
