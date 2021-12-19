package lambdas_04;

import java.util.function.IntSupplier;

public class EffectivelyFinal_01 {
    public static void main(String[] args) {
        // effectively final local variable:
        //      - if its initial value is never changed
        //      - introduced in order to avoid multithreading bugs
    }

    // ok
    static void a(int x) {
        int y = 1;
        IntSupplier supplier = () -> x + y;
    }

    // ok
    static void b(int x) {
        int y;
        y = 1;
        IntSupplier supplier = () -> x + y;
    }

    // ok
    static void c(int x) {
        int y;
        if (x > 10) y = 1;
        else y = 2;
        IntSupplier supplier = () -> x + y;
    }

    /*// will not compile
    static void d(int x) {
        int y;
        if (x < 10) {
            y = 1;
        }
        // y might not have been initialized
        IntSupplier supplier = () -> x + y;
    }

    // will not compile
    // java: local variables referenced from a lambda expression must be final or effectively final
    static void e(int x) {
        int y;
        if (x > 10) y = 1;
        y = 2;
        IntSupplier supplier = () -> x + y;
    }

    // will not compile
    // java: local variables referenced from a lambda expression must be final or effectively final
    static void f(int x) {
        IntSupplier supplier = () -> x + 1;
        x++;
    }*/
}
