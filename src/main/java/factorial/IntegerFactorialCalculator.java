package factorial;

public abstract class IntegerFactorialCalculator extends BasicFactorialCalculator<Integer> {
    @Override
    protected Integer identity() {
        return 1;
    }

    @Override
    protected final Integer getOverflowLimit() {
        return Integer.MAX_VALUE;
    }
}
