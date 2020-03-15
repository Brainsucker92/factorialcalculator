package factorial.impl;

import java.util.Map;

import factorial.LongFactorialCalculator;

public class RecursivePrimitiveFactorialCalculator extends LongFactorialCalculator {

    @Override
    public Long calculate(Map.Entry<Integer, Long> entry, int n) {
        Integer key = entry.getKey();
        Long value = entry.getValue();
        if (n - key > 0) {
            long fac = factorial(entry, n - 1);
            if ((Long.MAX_VALUE / n) < fac) {
                throw new ArithmeticException("Overflow detected for n=" + n);
            }
            return n * fac;
        }
        return value;
    }
}
