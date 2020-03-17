package factorial.impl;

import java.util.Map;

import factorial.LongFactorialCalculator;

public class RecursiveLongFactorialCalculator extends LongFactorialCalculator {

    @Override
    protected Long calculate(Map.Entry<Integer, Long> entry, int n) {
        Long prevResult = factorial(entry, n - 1);
        checkOverflow(prevResult, n);
        return n * prevResult;
    }
}
