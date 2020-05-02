package calculator.operations;

public class CloseBracket extends Operation {

    public CloseBracket() {
        priority = Priority.LOW;
    }

    // Todo bad idea
    @Override
    public int count(int a, int b) {
        return 0;
    }
}