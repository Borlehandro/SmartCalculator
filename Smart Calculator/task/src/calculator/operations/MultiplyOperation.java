package calculator.operations;

import java.math.BigInteger;

public class MultiplyOperation extends Operation {

    public MultiplyOperation() {
        priority = Priority.HIGH;
    }

    @Override
    public BigInteger count(BigInteger a, BigInteger b) {
        // System.err.println(a + "*" + b);
        return a.multiply(b);
    }
}
