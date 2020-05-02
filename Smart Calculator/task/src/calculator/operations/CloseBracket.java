package calculator.operations;

import java.math.BigInteger;

public class CloseBracket extends Operation {

    public CloseBracket() {
        priority = Priority.LOW;
    }

    // Todo bad idea
    @Override
    public BigInteger count(BigInteger a, BigInteger b) {
        return BigInteger.ZERO;
    }
}