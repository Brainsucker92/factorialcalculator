package factorial.impl;

import factorial.BasicFactorialCalculator;
import factorial.tools.ArithmeticOperations;

import java.util.Map;
import java.util.stream.LongStream;

public class IterativeFactorialCalculator<T extends Number> extends BasicFactorialCalculator<T> {

    public IterativeFactorialCalculator(ArithmeticOperations<T> operations) {
        super(operations);
    }

    @Override
    protected T calculate(Map.Entry<Integer, T> entry, int n) {
        Integer key = entry.getKey();
        T value = entry.getValue();
        T prevResult = LongStream.rangeClosed(key + 1, n).mapToObj(o -> operations.from(o))
                .reduce(operations.identity(), (x, y) -> operations.mul(x, y));
        return operations.mul(value, prevResult);
    }
}
