package factorial.impl;

import java.math.BigInteger;
import java.util.Map;

import factorial.BigIntegerFactorialCalculator;

public class RecursiveBigIntFactorialCalculator extends BigIntegerFactorialCalculator {

    @Override
    public BigInteger calculate(Map.Entry<Integer, BigInteger> entry, int n) {
        Integer key = entry.getKey();
        BigInteger value = entry.getValue();
        if (n - key > 0) {
            return BigInteger.valueOf(n).multiply(factorial(entry, n - 1));
        }
        return value;
    }
}
