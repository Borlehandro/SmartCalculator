package calculator.expressions;

import calculator.VariablesPool;
import calculator.exceptions.ExpressionFormatException;
import calculator.exceptions.InvalidCommandException;
import calculator.exceptions.UnknownVariableException;

public abstract class Expression {

    public static VariablesPool pool = new VariablesPool();

    public abstract void execute() throws UnknownVariableException, InvalidCommandException, ExpressionFormatException; // trows ...
}
