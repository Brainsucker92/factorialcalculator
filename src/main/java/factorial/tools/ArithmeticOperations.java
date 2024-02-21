package factorial.tools;

public interface ArithmeticOperations<T extends Number> {

    T add(T t1, T t2);

    T sub(T t1, T t2);

    T mul(T t1, T t2);

    T div(T t1, T t2);

    T identity();

    T from(int n);

    T from(long l);
}
