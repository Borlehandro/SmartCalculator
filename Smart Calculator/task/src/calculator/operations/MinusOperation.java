package calculator.operations;

import java.math.BigInteger;

public class MinusOperation extends Operation {

    public MinusOperation() {
        priority = Priority.MIDDLE;
    }

    @Override
    public BigInteger count(BigInteger a, BigInteger b) {
        // System.err.println(b + "-" + a);
        return b.subtract(a);
    }
}
