package factorial.impl;

import java.math.BigInteger;
import java.util.Map;
import java.util.stream.IntStream;

public class IterativeBigIntFactorialCalculator extends BasicFactorialCalculator<BigInteger> {

    @Override
    protected BigInteger identity() {
        return BigInteger.ONE;
    }

    @Override
    public BigInteger calculate(Map.Entry<Integer, BigInteger> entry, int n) {
        Integer key = entry.getKey();
        BigInteger value = entry.getValue();

        return value.multiply(IntStream.rangeClosed(key + 1, n)
                                  .mapToObj(BigInteger::valueOf)
                                  .reduce(identity(), BigInteger::multiply));
    }
}
