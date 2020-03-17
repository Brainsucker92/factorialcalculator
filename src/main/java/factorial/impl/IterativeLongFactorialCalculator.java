package factorial.impl;

import java.util.Map;
import java.util.stream.LongStream;

import factorial.LongFactorialCalculator;

public class IterativeFactorialCalculator extends LongFactorialCalculator {

    @Override
    protected Long calculate(Map.Entry<Integer, Long> entry, int n) {
        Integer key = entry.getKey();
        Long value = entry.getValue();
        Long prevResult = LongStream.rangeClosed(key + 1, n)
                                    .reduce(identity(), (x, y) -> {
                                        checkOverflow(x, ((int) y));
                                        return x * y;
                                    });
        checkOverflow(prevResult, key);
        return value * prevResult;
    }
}
