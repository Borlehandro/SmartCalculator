package calculator.expressions;

import calculator.exceptions.UnknownVariableException;

public class GetValueExpression extends Expression {

    private final String name;

    GetValueExpression(String s) {
        name = s;
    }

    @Override
    public void execute() throws UnknownVariableException {
        System.out.println(pool.getValue(name));
    }
}