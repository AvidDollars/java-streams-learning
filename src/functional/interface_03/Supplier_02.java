package functional.interface_03;

import java.util.List;
import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class Supplier_02 {
    public static void main(String[] args) {

        // Supplier functional interface → single abstract method 'get'
        // 'get' method does not take any argument
        Supplier<Integer> randomInteger = () -> (int)(Math.random() * 10);
        randomInteger.get(); // auto-boxing (int → Integer) will occur... expensive operation


        // IntSupplier functional interface → single abstract method 'getAsInt'
        IntSupplier randomInt = () -> (int)(Math.random() * 10);
        randomInt.getAsInt(); // primitive type is not boxed, more optimized approach

        // other interfaces for primitive types:
        // LongSupplier, DoubleSupplier, BooleanSupplier

        // eg.: returning random element from list
        List<Integer> integerList = List.of(7, 13, 23, 42, 69, 420, 666);
        IntSupplier randomElement = () -> integerList.get(
                new Random().nextInt(integerList.size()));
        randomElement.getAsInt(); // returns random integer from the list

    }

}
