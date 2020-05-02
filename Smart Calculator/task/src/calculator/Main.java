package calculator;

import calculator.exceptions.ExpressionFormatException;
import calculator.exceptions.InvalidCommandException;
import calculator.exceptions.UnknownVariableException;
import calculator.expressions.Expression;
import calculator.expressions.ExpressionFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            String line = scanner.nextLine().replaceAll("\n", "");

            Expression expression;
            try {
                // Todo fix
                if(line.equals("/exit")) {
                    System.out.println("Bye!");
                    return;
                }
                if(!line.equals("")) {
                    expression = ExpressionFactory.create(line);
                    expression.execute();
                }
            } catch (UnknownVariableException | ExpressionFormatException | InvalidCommandException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
