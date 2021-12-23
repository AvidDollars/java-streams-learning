package building.streams_09;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IterateAndGenerate_02 {
    public static void main(String[] args) {
        // POTENTIALLY INFINITE STREAMS:

        // Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        List<Integer> numbersOne = Stream
                //num++ will not work
                .iterate(0, num -> ++num)
                .limit(5)
                .collect(Collectors.toList());
        // numbersOne → [0, 1, 2, 3, 4]

        List<Integer> numbersTwo = Stream
                // iterate(seed, Predicate, UnaryOperator)
                .iterate(0, i -> i < 100, i -> i + 10)
                .collect(Collectors.toList());
        // numbersTwo; → [0, 10, 20, 30, 40, 50, 60, 70, 80, 90]

        // Stream<T> generate(Supplier<? extends T> s)
        List<Integer> numbersThree = Stream
                .generate(() -> 1)
                .limit(5)
                .collect(Collectors.toList());
        // numbersThree; → [1, 1, 1, 1, 1]

    }
}
