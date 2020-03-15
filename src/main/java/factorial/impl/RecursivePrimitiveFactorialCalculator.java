package factorial.impl;

import factorial.LongFactorialCalculator;

public class RecursivePrimitiveFactorialCalculator extends LongFactorialCalculator {

    @Override
    public Long calculate(int n) {
        return n * factorial(n - 1);
    }
}
