package calculator.operations;

public class MinusOperation extends Operation {

    public MinusOperation() {
        priority = Priority.MIDDLE;
    }

    @Override
    public int count(int a, int b) {
        // System.err.println(b + "-" + a);
        return b - a;
    }
}
