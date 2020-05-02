package calculator.operations;

public class OpenBracket extends Operation {

    public OpenBracket() {
        priority = Priority.MINIMUM;
    }

    // Todo bad idea
    @Override
    public int count(int params, int b) {
        return 0;
    }
}
