package calculator.operations;

import java.math.BigInteger;

public class DivideOperation extends Operation {

    public DivideOperation() {
        priority = Priority.HIGH;
    }

    @Override
    public BigInteger count(BigInteger a, BigInteger b) {
        // System.err.println(b + "/" + a);
        return b.divide(a);
    }
}