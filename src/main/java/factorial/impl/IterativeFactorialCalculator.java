package factorial.impl;

import java.util.Map;
import java.util.stream.IntStream;

public class IterativeFactorialCalculator extends BasicFactorialCalculator<Integer> {

    @Override
    protected Integer identity() {
        return 1;
    }

    @Override
    public Integer calculate(Map.Entry<Integer, Integer> entry, int n) {
        Integer key = entry.getKey();
        Integer value = entry.getValue();

        return value * IntStream.rangeClosed(key + 1, n)
                                .reduce(identity(), (i1, i2) -> i1 * i2);
    }
}
