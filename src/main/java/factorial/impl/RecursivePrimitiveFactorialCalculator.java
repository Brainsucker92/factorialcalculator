package factorial.impl;

import java.util.Map;

public class RecursivePrimitiveFactorialCalculator extends BasicFactorialCalculator<Integer> {

    @Override
    public Integer calculate(Map.Entry<Integer, Integer> entry, int n) {
        Integer key = entry.getKey();
        Integer value = entry.getValue();
        if (n - key > 0) {
            long result = (long) n * (long) factorial(entry,n - 1);
            return Math.toIntExact(result);
        }
        return value;
    }

    @Override
    protected Integer identity() {
        return 1;
    }
}
