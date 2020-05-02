package calculator.operations;

public abstract class Operation {
    public Priority priority;
    public abstract int count(int params, int b);
}
