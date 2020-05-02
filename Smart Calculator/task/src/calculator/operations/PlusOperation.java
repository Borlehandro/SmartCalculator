package calculator.operations;

import java.math.BigInteger;

public class PlusOperation extends Operation {

    public PlusOperation() {
        priority = Priority.MIDDLE;
    }

    @Override
    public BigInteger count(BigInteger a, BigInteger b) {
        // System.err.println(a + "+" + b);
        return a.add(b);
    }
}