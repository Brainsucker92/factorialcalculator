package factorial.impl;

import java.util.Map;
import java.util.stream.LongStream;

public class IterativeFactorialCalculator extends BasicFactorialCalculator<Long> {

    @Override
    protected Long identity() {
        return 1L;
    }

    @Override
    public Long calculate(Map.Entry<Integer, Long> entry, int n) {
        Integer key = entry.getKey();
        Long value = entry.getValue();

        return value * LongStream.rangeClosed(key + 1, n)
                                 .reduce(identity(), (i1, i2) -> {
                                     if ((Long.MAX_VALUE / i1) < i2) {
                                         throw new ArithmeticException("Overflow detected");
                                     }
                                     return i1 * i2;
                                 });
    }
}
