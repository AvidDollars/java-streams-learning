package parallel.streams_10;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

public class SequentialVsParallel_02 {
    public static void main(String[] args) {
        final long TO_RANGE = 1_000_000_000;

        parallelStream(TO_RANGE); // time elapsed: 151ms
        sequentialStream(TO_RANGE); // time elapsed: 768ms
    }

    static long sequentialStream(long to) {
        Instant t0 = Instant.now();

        String methodName = new Object(){}
                .getClass()
                .getEnclosingMethod()
                .getName();

        long consecutiveSum = LongStream
                .rangeClosed(1, to)
                .sum();

        Instant t1 = Instant.now();
        System.out.printf("(%s) time elapsed: %sms\n", methodName, Duration.between(t0, t1).toMillis());

        return consecutiveSum;
    }

    static long parallelStream(long to) {
        Instant t0 = Instant.now();

        String methodName = new Object(){}
                .getClass()
                .getEnclosingMethod()
                .getName();

        long consecutiveSum = LongStream
                .rangeClosed(1, to)
                .parallel()
                .sum();

        Instant t1 = Instant.now();
        System.out.printf("(%s) time elapsed: %sms\n", methodName, Duration.between(t0, t1).toMillis());

        return consecutiveSum;
    }
}
