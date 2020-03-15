package factorial.impl;

import java.math.BigInteger;
import java.util.Map;

import factorial.BigIntegerFactorialCalculator;

public class RecursiveBigIntFactorialCalculator extends BigIntegerFactorialCalculator {

    @Override
    public BigInteger calculate(Map.Entry<Integer, BigInteger> entry, int n) {
        return BigInteger.valueOf(n).multiply(factorial(entry, n - 1));
    }
}
