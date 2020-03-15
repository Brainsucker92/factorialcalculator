package factorial.impl;

import java.util.Map;
import java.util.stream.LongStream;

public class IterativeFactorialCalculator extends LongFactorialCalculator {

    @Override
    public Long calculate(Map.Entry<Integer, Long> entry, int n) {
        Integer key = entry.getKey();
        Long value = entry.getValue();

        return value * LongStream.rangeClosed(key + 1, n)
                                 .reduce(identity(), (x, y) -> {
                                     if ((Long.MAX_VALUE / x) < y) {
                                         throw new ArithmeticException("Overflow detected");
                                     }
                                     return x * y;
                                 });
    }
}
