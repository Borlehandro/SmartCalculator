package calculator.exceptions;

public class InvalidCommandException extends CalculatorException {

    @Override
    public String getMessage() {
        return "Unknown command";
    }
}
