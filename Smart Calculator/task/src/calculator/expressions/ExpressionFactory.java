package calculator.expressions;

import calculator.ExpressionChecker;
import calculator.exceptions.ExpressionFormatException;
import calculator.exceptions.UnknownVariableException;

public class ExpressionFactory {

    public static Expression create(String literal) throws ExpressionFormatException, UnknownVariableException {

        switch (ExpressionChecker.check(literal)) {

            case DEFINE:
                return new DefineExpression(literal);

            case SOLVE:
                return new CalculateExpression(literal);

            case GET:
                return new GetValueExpression(literal);

            case COMMAND:
                return new CommandExpression(literal);

            default:
                throw new ExpressionFormatException();
        }


    }

}
