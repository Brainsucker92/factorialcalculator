package factorial.impl;

import java.util.Map;

import factorial.LongFactorialCalculator;

public class RecursivePrimitiveFactorialCalculator extends LongFactorialCalculator {

    @Override
    protected Long calculate(Map.Entry<Integer, Long> entry, int n) {
        Integer key = entry.getKey();
        Long value = entry.getValue();
        if (n == key) {
            return value;
        }
        Long prevResult = factorial(entry, n - 1);
        checkOverflow(prevResult, n);
        return n * prevResult;
    }
}
