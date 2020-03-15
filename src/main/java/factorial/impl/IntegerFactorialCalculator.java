package factorial.impl;

public abstract class IntegerFactorialCalculator extends BasicFactorialCalculator<Integer> {
    @Override
    protected Integer identity() {
        return 1;
    }
}
