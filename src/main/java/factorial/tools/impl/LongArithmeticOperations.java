package factorial.tools.impl;

import factorial.tools.ArithmeticOperations;

public class LongArithmeticOperations implements ArithmeticOperations<Long> {
    @Override
    public Long add(Long t1, Long t2) {
        return t1 + t2;
    }

    @Override
    public Long sub(Long t1, Long t2) {
        return t1 - t2;
    }

    @Override
    public Long mul(Long t1, Long t2) {
        return t1 * t2;
    }

    @Override
    public Long div(Long t1, Long t2) {
        return t1 / t2;
    }

    @Override
    public Long identity() {
        return 1L;
    }

    @Override
    public Long from(int n) {
        return (long) n;
    }

    @Override
    public Long from(long l) {
        return l;
    }
}
