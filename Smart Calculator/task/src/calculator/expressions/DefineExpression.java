package calculator.expressions;

import calculator.ExpressionChecker;
import calculator.exceptions.UnknownVariableException;

public class DefineExpression extends Expression {

    private final String variable;
    private final int value;

    public DefineExpression(String s) throws UnknownVariableException {
        s = s.replaceAll(" ", "");
        variable = s.substring(0, s.indexOf('='));
        String any = s.substring(s.indexOf('=') + 1);
        // System.err.println(any);
        if(ExpressionChecker.isNumber(any))
            value = Integer.parseInt(any);
        else {
            value = pool.getValue(any);
        }
    }

    @Override
    public void execute() {
        pool.put(variable, value);
    }
}