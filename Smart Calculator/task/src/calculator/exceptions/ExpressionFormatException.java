package calculator.exceptions;

public class ExpressionFormatException extends CalculatorException {

    @Override
    public String getMessage() {
        return "Invalid expression";
    }

    public ExpressionFormatException(Throwable th) {
        this.initCause(th);
    }

    public ExpressionFormatException() {

    }

    //...

}
