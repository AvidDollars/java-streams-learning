package lambdas_04;

import java.util.function.Consumer;

public class ThisKeyword_02 {

    public static void main(String[] args) {
        ThisKeyword_02 object = new ThisKeyword_02();

        // 'this' in lambda refers to the enclosing environment
        object.test(); // ThisKeyword_02{}
    }

    void test() {
        Consumer<String> test = string -> {
            System.out.println(this);
        };
        test.accept("dummy string");
    }

    @Override
    public String toString() {
        return "ThisKeyword_02{}";
    }
}
