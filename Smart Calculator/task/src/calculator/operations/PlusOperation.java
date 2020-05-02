package calculator.operations;

public class PlusOperation extends Operation {

    public PlusOperation() {
        priority = Priority.MIDDLE;
    }

    @Override
    public int count(int a, int b) {
        // System.err.println(a + "+" + b);
        return a + b;
    }
}