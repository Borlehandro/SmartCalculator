package calculator.operations;

import java.math.BigInteger;

public class OpenBracket extends Operation {

    public OpenBracket() {
        priority = Priority.MINIMUM;
    }

    // Todo bad idea
    @Override
    public BigInteger count(BigInteger params, BigInteger b) {
        return BigInteger.ZERO;
    }
}
