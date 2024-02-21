package factorial.tools.impl;

import factorial.tools.ArithmeticOperations;

import java.math.BigInteger;

public class BigIntegerArithmeticOperations implements ArithmeticOperations<BigInteger> {

    @Override
    public BigInteger add(BigInteger t1, BigInteger t2) {
        return t1.add(t2);
    }

    @Override
    public BigInteger sub(BigInteger t1, BigInteger t2) {
        return t1.subtract(t2);
    }

    @Override
    public BigInteger mul(BigInteger t1, BigInteger t2) {
        return t1.multiply(t2);
    }

    @Override
    public BigInteger div(BigInteger t1, BigInteger t2) {
        return t1.divide(t2);
    }

    @Override
    public BigInteger identity() {
        return BigInteger.ONE;
    }

    @Override
    public BigInteger from(int n) {
        return BigInteger.valueOf(n);
    }

    @Override
    public BigInteger from(long l) {
        return BigInteger.valueOf(l);
    }
}