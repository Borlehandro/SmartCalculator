package calculator.operations;

import java.math.BigInteger;

public abstract class Operation {
    public Priority priority;
    public abstract BigInteger count(BigInteger params, BigInteger b);
}
