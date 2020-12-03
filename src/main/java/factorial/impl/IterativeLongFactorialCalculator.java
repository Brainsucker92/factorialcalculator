package factorial.impl;

import java.util.Map;
import java.util.stream.LongStream;

import factorial.LongFactorialCalculator;

public class IterativeLongFactorialCalculator extends LongFactorialCalculator {

    @Override
    protected Long calculate(Map.Entry<Integer, Long> entry, int n) {
        Integer key = entry.getKey();
        Long value = entry.getValue();
        Long prevResult = LongStream.rangeClosed(key + 1, n)
                                    .reduce(identity(), (x, y) -> x * y);
        return value * prevResult;
    }
}
