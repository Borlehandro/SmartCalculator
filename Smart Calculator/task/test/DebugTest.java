import calculator.ExpressionChecker;
import calculator.exceptions.*;
import calculator.expressions.Expression;
import calculator.expressions.ExpressionFactory;
import calculator.operations.MinusOperation;
import calculator.operations.MultiplyOperation;
import calculator.operations.Operation;
import calculator.operations.OperationFactory;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class DebugTest {

    @Test
    public void testExceptionFactoring() {
        try {

            Expression a = ExpressionFactory.create("alt = 1");
            System.out.println(a.getClass());
            a.execute();
            Expression def = ExpressionFactory.create("beta = 2");
            System.out.println(def.getClass());
            def.execute();
            Expression g = ExpressionFactory.create("alt");
            System.out.println(g.getClass());
            g.execute();
            Expression b = ExpressionFactory.create("alt = b");
            System.out.println(b.getClass());
            b.execute();
            g.execute();
//            Expression c = ExpressionFactory.create("1 = 1");
//            System.out.println(c.getClass());
//            c.execute();


        } catch (CalculatorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOperationFactory() {
        try {
            Operation operation = OperationFactory.create("=");
            System.out.println(operation.getClass());
            System.out.println(operation.count(2,2));
        } catch (ExpressionFormatException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testChecker() {

        try {
            // 3 + 8 * ((4 + 3) * 2 + 1) - 6 / (2 + 1)
            Expression def = ExpressionFactory.create("alpha=8");
            def.execute();
            Expression e = ExpressionFactory.create("3 + alpha * ((4 + 3) * 2 + 1) - 6 / (2 + 1)");
            e.execute();
        } catch (ExpressionFormatException | UnknownVariableException | InvalidCommandException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testCalculation() {
        try {
            Expression a = ExpressionFactory.create("2 + (2 +- -3)");
            a.execute();
        } catch (ExpressionFormatException | UnknownVariableException | InvalidCommandException e) {
            e.printStackTrace();
        }
    }


}