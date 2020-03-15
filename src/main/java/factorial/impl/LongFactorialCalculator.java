package factorial.impl;

public abstract class LongFactorialCalculator extends BasicFactorialCalculator<Long> {
    @Override
    protected Long identity() {
        return 1L;
    }
}
