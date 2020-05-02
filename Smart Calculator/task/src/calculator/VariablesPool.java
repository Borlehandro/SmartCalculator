package calculator;

import calculator.exceptions.UnknownVariableException;

import java.util.HashMap;
import java.util.Map;

public class VariablesPool {

    private Map<String, Integer> pool = new HashMap<>();

    public void put(String name, Integer value) {
            pool.put(name, value);
    }

    public int getValue(String name) throws UnknownVariableException {
        if(pool.containsKey(name))
            return pool.get(name);
        else
            throw new UnknownVariableException();
    }

    public boolean containsKey(String key){
        return pool.containsKey(key);
    }

}
