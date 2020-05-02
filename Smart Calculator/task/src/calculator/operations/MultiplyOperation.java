package calculator.operations;

public class MultiplyOperation extends Operation {

    public MultiplyOperation() {
        priority = Priority.HIGH;
    }

    @Override
    public int count(int a, int b) {
        // System.err.println(a + "*" + b);
        return a * b;
    }
}
