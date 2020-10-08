package factories.impl;

import factorial.BigIntegerFactorialCalculator;
import factorial.LongFactorialCalculator;
import factories.FactorialCalculatorFactory;

public class IterativeFactorialCalculatorFactory implements FactorialCalculatorFactory {

    private static FactorialCalculatorFactory instance;

    protected IterativeFactorialCalculatorFactory() {
        // restrict object creation
    }

    public static synchronized FactorialCalculatorFactory getInstance() {
        if (instance == null) {
            instance = new IterativeFactorialCalculatorFactory();
        }
        return instance;
    }

    @Override
    public LongFactorialCalculator getLongCalculator() {
        return null;
    }

    @Override
    public BigIntegerFactorialCalculator getBigIntegerCalculator() {
        return null;
    }
}
