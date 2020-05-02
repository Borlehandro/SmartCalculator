package calculator.exceptions;

public class UnknownVariableException extends CalculatorException {
    @Override
    public String getMessage() {
        return "Unknown variable";
    }
}
