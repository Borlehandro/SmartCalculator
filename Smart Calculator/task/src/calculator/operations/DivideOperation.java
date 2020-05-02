package calculator.operations;

public class DivideOperation extends Operation {

    public DivideOperation() {
        priority = Priority.HIGH;
    }

    @Override
    public int count(int a, int b) {
        // System.err.println(b + "/" + a);
        return b / a;
    }
}