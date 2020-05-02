package calculator.expressions;

import calculator.ExpressionChecker;
import calculator.exceptions.ExpressionFormatException;
import calculator.exceptions.UnknownVariableException;
import calculator.operations.CloseBracket;
import calculator.operations.OpenBracket;
import calculator.operations.Operation;
import calculator.operations.OperationFactory;

import java.math.BigInteger;
import java.util.LinkedList;

public class CalculateExpression extends Expression {

    private final LinkedList<Operation> operationsStack = new LinkedList<>();
    private final LinkedList<BigInteger> argumentsStack = new LinkedList<>();
    private int balancer = 0;

    CalculateExpression(String s) throws ExpressionFormatException, UnknownVariableException {
        // String[] items = s.split(" ");
        StringBuilder builder = new StringBuilder();
        ExpressionChecker.CharType bufferType = null;
        int i = 0;
        while (i < s.length() || builder.length() > 0) {

            char item = '\0';
            ExpressionChecker.CharType type = null;
            if (i < s.length()) {
                item = s.charAt(i);
                if (item == ' ') {
                    ++i;
                    continue;
                }
                type = ExpressionChecker.getCharType(item);
                //System.out.println(item + " --- " + type);
            }

            //System.err.println("BUFFER: " + builder + " --- " + bufferType);

            if (bufferType == null) {
                builder.append(item);
                bufferType = type;
            } else if (type == bufferType && builder.charAt(builder.length() - 1) != ')' && item != '(') {
                builder.append(item);
            } else {
                switch (bufferType) {
                    case NUMBER:
                        BigInteger number = new BigInteger(builder.toString());
                        argumentsStack.push(number);
                        builder = new StringBuilder();
                        if (item != '\0') {
                            builder.append(item);
                            bufferType = type;
                        }
                        break;

                    case VAR:
                        if (!pool.containsKey(builder.toString()))
                            throw new UnknownVariableException();
                        else {
                            BigInteger num = pool.getValue(builder.toString());
                            argumentsStack.push(num);
                            builder = new StringBuilder();
                            if (item != '\0') {
                                builder.append(item);
                                bufferType = type;
                            }
                        }
                        break;

                    case OPERATION:

                        Operation operation = OperationFactory.create(simplify(builder.toString()));

                        if (operation.getClass().equals(OpenBracket.class))
                            balancer--;
                        else if (operation.getClass().equals(CloseBracket.class))
                            balancer++;

                        builder = new StringBuilder();
                        if (item != '\0') {
                            builder.append(item);
                            bufferType = type;
                        }

                        if (!operationsStack.isEmpty()) {

                            //System.out.println(operation + " " + operation.priority);

                            while (!operation.getClass().equals(OpenBracket.class) && !operationsStack.isEmpty()
                                    && operationsStack.peek().priority.getValue() >= operation.priority.getValue()) {

                                Operation current = operationsStack.pop();
                                //System.err.println("Popped : " + current);
                                if (!current.getClass().equals(OpenBracket.class)) {
                                    argumentsStack.push(current.count(argumentsStack.pop(), argumentsStack.pop()));
                                }
                            }
                            if (operation.getClass().equals(CloseBracket.class)) {
                                if (operationsStack.isEmpty())
                                    throw new ExpressionFormatException();
                                operationsStack.pop();
                            }
                        }
                        if (!operation.getClass().equals(CloseBracket.class))
                            operationsStack.push(operation);
                        break;
                }
            }

            //System.out.println(argumentsStack);
            //System.out.println(operationsStack);

            ++i;
        }

        if (builder.length() != 0) {
            System.err.println("ERROR!");
        }

        while (!operationsStack.isEmpty()) {
            Operation current = operationsStack.pop();
            if (!current.getClass().equals(OpenBracket.class)) {
                argumentsStack.push(current.count(argumentsStack.pop(), argumentsStack.pop()));
            }
        }
    }

    @Override
    public void execute() throws ExpressionFormatException {
        if (balancer == 0)
            System.out.println(argumentsStack.peek());
        else throw new ExpressionFormatException();
    }

    private static String simplify(String symbol) {
        if (symbol.contains("+") || symbol.contains("-")) {
            long minus = symbol.chars().filter(i -> i == '-').count();
            return minus % 2 == 0 ? "+" : "-";
        } else return symbol;
    }
}