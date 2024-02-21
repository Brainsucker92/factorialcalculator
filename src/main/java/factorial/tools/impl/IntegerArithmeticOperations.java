package factorial.tools.impl;

import factorial.tools.ArithmeticOperations;

public class IntegerArithmeticOperations implements ArithmeticOperations<Integer> {
    @Override
    public Integer add(Integer t1, Integer t2) {
        return t1 + t2;
    }

    @Override
    public Integer sub(Integer t1, Integer t2) {
        return t1 - t2;
    }

    @Override
    public Integer mul(Integer t1, Integer t2) {
        return t1 * t2;
    }

    @Override
    public Integer div(Integer t1, Integer t2) {
        return t1 / t2;
    }

    @Override
    public Integer identity() {
        return 1;
    }

    @Override
    public Integer from(int n) {
        return n;
    }

    @Override
    public Integer from(long l) {
        return Math.toIntExact(l);
    }
}
