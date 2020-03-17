package factorial.impl;

import java.util.Map;
import java.util.stream.LongStream;

import factorial.LongFactorialCalculator;

public class IterativeFactorialCalculator extends LongFactorialCalculator {

    @Override
    protected Long calculate(Map.Entry<Integer, Long> entry, int n) {
        Integer key = entry.getKey();
        Long value = entry.getValue();
        return value * LongStream.rangeClosed(key + 1, n)
                                 .reduce(identity(), (x, y) -> {
                                     Long next = x * y;
                                     checkOverflow(next, n + 1);
                                     return next;
                                 });
    }
}
