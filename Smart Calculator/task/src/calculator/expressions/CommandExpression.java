package calculator.expressions;

import calculator.exceptions.InvalidCommandException;
import calculator.exceptions.UnknownVariableException;

public class CommandExpression extends Expression {

    private final String command;

    public CommandExpression(String command) {
        this.command = command;
    }

    @Override
    public void execute() throws InvalidCommandException {
        // Todo make with enum
        switch (command) {
            case "/info":
                System.out.println("Some info.");
                break;

            case "/help":
                System.out.println("How to use it..))");
                break;

            default:
                throw new InvalidCommandException();

        }

    }
}