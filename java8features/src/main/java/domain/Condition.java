package domain;

@FunctionalInterface
public interface Condition<T> {
    boolean check(T t);
}
