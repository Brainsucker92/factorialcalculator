package factorial.impl;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import factorial.FactorialCalculator;

public class MemoizeFactorialCalculator<T extends Number> implements FactorialCalculator<T> {

    private final FactorialCalculator<T> calculator;

    private final TreeMap<Integer, T> factorialBuffer = new TreeMap<>(Comparator.naturalOrder());

    public MemoizeFactorialCalculator(FactorialCalculator<T> calculator) {
        this.calculator = calculator;
    }

    @Override
    public T factorial(int n) {
        int i = 0;
        T identity = calculator.factorial(i);
        Map.Entry<Integer, T> entry = new AbstractMap.SimpleEntry<>(i, identity);
        return factorial(entry, n);
    }

    @Override
    public T factorial(Map.Entry<Integer, T> entry, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Cannot calculate factorial of negative number");
        }

        Integer entryKey = entry.getKey();
        if (!factorialBuffer.containsKey(entryKey)) {
            T entryValue = entry.getValue();
            factorialBuffer.put(entryKey, entryValue);
        }

        if (factorialBuffer.containsKey(n)) {
            // Result is already known
            return factorialBuffer.get(n);
        }

        // Fill up the buffer until we reach the desired value.
        do {
            // Find current floorEntry:
            Map.Entry<Integer, T> floorEntry = factorialBuffer.floorEntry(n);
            Integer floorEntryKey = floorEntry.getKey();

            // Calculate new entry:
            int newKey = floorEntryKey + 1;
            T newValue = calculator.factorial(floorEntry, newKey);

            // Update current data:
            factorialBuffer.put(newKey, newValue);
        } while (factorialBuffer.floorEntry(n).getKey() < n);

        return factorialBuffer.get(n);
    }
}
