package factorial.impl;

import factorial.FactorialCalculator;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MemoizedFactorialCalculator<T extends Number> implements FactorialCalculator<T> {

    private final FactorialCalculator<T> calculator;

    private final TreeMap<Integer, T> factorialBuffer = new TreeMap<>(Comparator.naturalOrder());

    public MemoizedFactorialCalculator(FactorialCalculator<T> calculator) {
        this.calculator = calculator;
    }

    @Override
    public T factorial(int n) {
        int i = 0;
        T identity = calculator.factorial(i);
        Map.Entry<Integer, T> entry = new AbstractMap.SimpleImmutableEntry<>(i, identity);
        return factorial(entry, n);
    }

    @Override
    public T factorial(Map.Entry<Integer, T> entry, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Cannot calculate factorial of negative number");
        }
        checkBufferContainsEntry(entry);
        if (factorialBuffer.containsKey(n)) {
            // Result is already known
            return factorialBuffer.get(n);
        }
        Map.Entry<Integer, T> floorEntry = getFloorEntry(n);
        // Fill up the buffer until we reached the desired value.
        while (floorEntry.getKey() < n) {
            Integer floorEntryKey = floorEntry.getKey();

            // Calculate new entry:
            int newKey = floorEntryKey + 1;
            T newValue = calculator.factorial(floorEntry, newKey);

            // Update current data:
            factorialBuffer.put(newKey, newValue);
            floorEntry = new AbstractMap.SimpleImmutableEntry<>(newKey, newValue);
        }
        return factorialBuffer.get(n);
    }

    private Map.Entry<Integer, T> getFloorEntry(int n) {
        Map.Entry<Integer, T> floorEntry = factorialBuffer.floorEntry(n);
        if (floorEntry == null) {
            floorEntry = createIdentityEntry();
        }
        return floorEntry;
    }

    private Map.Entry<Integer, T> createIdentityEntry() {
        Map.Entry<Integer, T> floorEntry;
        int i = 0;
        T identity = calculator.factorial(i);
        floorEntry = new AbstractMap.SimpleImmutableEntry<>(i, identity);
        factorialBuffer.put(i, identity);
        return floorEntry;
    }

    private void checkBufferContainsEntry(Map.Entry<Integer, T> entry) {
        Integer entryKey = entry.getKey();
        if (!factorialBuffer.containsKey(entryKey)) {
            T entryValue = entry.getValue();
            factorialBuffer.put(entryKey, entryValue);
        }
    }
}
