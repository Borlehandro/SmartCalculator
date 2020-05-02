package calculator;

import calculator.exceptions.ExpressionFormatException;

public class ExpressionChecker {

    private static final String itemRegex = "([-+]?(([a-zA-Z])|([0-9]))+)";

    public enum ExpressionType {
        SOLVE,
        DEFINE,
        GET,
        COMMAND,
        UNKNOWN
    }

    public enum CharType {
        NUMBER,
        VAR,
        OPERATION
    }

    public static ExpressionType check(String expression) {

        if (expression.matches("[a-zA-Z]+ *= *-?((\\d+)|([a-zA-Z]+))")) {
            return ExpressionType.DEFINE;
        } else if (expression.matches("[a-zA-Z]+")) {
            return ExpressionType.GET;
        } else if (expression.matches("^(\\(|" + itemRegex + ").*") && expression.matches(".*(" + itemRegex + "|\\))$")) {
            return ExpressionType.SOLVE;
        }  else if(expression.matches("^/.+")){
            return ExpressionType.COMMAND;
        } else
            return ExpressionType.UNKNOWN;
    }

    public static CharType getCharType(char c) throws ExpressionFormatException {
        // Todo other way?
        String s = Character.toString(c);
        if(s.matches("[a-zA-Z]"))
            return CharType.VAR;
        else if(s.matches("\\d"))
            return CharType.NUMBER;
        else if(s.matches("[+\\-*/()]"))
            return CharType.OPERATION;
        else
            throw new ExpressionFormatException();
    }

    public static boolean isNumber(String s) {
        return s.matches("[-+]?\\d+");
    }


}