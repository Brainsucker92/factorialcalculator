package factorial.impl;

import java.util.Map;

public class RecursivePrimitiveFactorialCalculator extends BasicFactorialCalculator<Long> {

    @Override
    public Long calculate(Map.Entry<Integer, Long> entry, int n) {
        Integer key = entry.getKey();
        Long value = entry.getValue();
        if (n - key > 0) {
            return n * factorial(entry, n - 1);
        }
        return value;
    }

    @Override
    protected Long identity() {
        return 1L;
    }
}
