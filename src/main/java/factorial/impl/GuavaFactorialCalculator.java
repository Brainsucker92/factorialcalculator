package factorial.impl;

import java.math.BigInteger;
import java.util.Map;

import com.google.common.math.BigIntegerMath;
import factorial.FactorialCalculator;

public class GuavaFactorialCalculator implements FactorialCalculator<BigInteger> {
    @Override
    public BigInteger factorial(int n) {
        return BigIntegerMath.factorial(n);
    }

    @Override
    public BigInteger factorial(Map.Entry<Integer, BigInteger> entry, int n) {
        // Unfortunately nothing can be reused here.
        return factorial(n);
    }
}
