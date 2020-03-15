package factorial.impl;

import java.util.stream.LongStream;

import factorial.LongFactorialCalculator;

public class IterativeFactorialCalculator extends LongFactorialCalculator {

    @Override
    public Long calculate(int n) {
        return LongStream.rangeClosed(2, n)
                         .reduce(identity(), (x, y) -> x * y);
    }
}
