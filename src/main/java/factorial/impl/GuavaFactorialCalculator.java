package factorial.impl;

import java.math.BigInteger;
import java.util.Map;

import com.google.common.math.BigIntegerMath;

public class GuavaFactorialCalculator extends BasicFactorialCalculator<BigInteger> {

    @Override
    protected BigInteger calculate(Map.Entry<Integer, BigInteger> entry, int n) {
        return BigIntegerMath.factorial(n);
    }

    @Override
    protected BigInteger identity() {
        return BigInteger.ONE;
    }
}
