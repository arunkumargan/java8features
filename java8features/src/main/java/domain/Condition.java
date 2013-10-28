package domain;

public interface Condition<T> {
    boolean test(T t);
}
