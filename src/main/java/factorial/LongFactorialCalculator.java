package factorial;

public abstract class LongFactorialCalculator extends BasicFactorialCalculator<Long> {
    @Override
    protected Long identity() {
        return 1L;
    }

    @Override
    protected final Long getOverflowLimit() {
        return Long.MAX_VALUE;
    }
}
