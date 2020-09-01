package factorial.impl;

import java.math.BigInteger;
import java.util.Map;

import com.google.common.math.BigIntegerMath;
import factorial.BigIntegerFactorialCalculator;

public class GuavaFactorialCalculator extends BigIntegerFactorialCalculator {

    @Override
    protected BigInteger calculate(Map.Entry<Integer, BigInteger> entry, int n) {
        if (entry.getKey() == n) {
            return entry.getValue();
        }
        return BigIntegerMath.factorial(n);
    }
}
