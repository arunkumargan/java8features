package lambda;

@FunctionalInterface
public interface Foo2<I, O> {
    O doSomething(I input);
}
