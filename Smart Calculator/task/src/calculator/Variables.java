package calculator;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Variables {

    Map<String, BigInteger> map;

    Variables() {
        map = new HashMap<>();
    }

    public void add(String variable, BigInteger value) {
        map.put(variable, value);
    }

    public boolean isVariable(String variable) {
        //System.out.println("isVariable(String variable)");
        return map.containsKey(variable);
    }

    public BigInteger getVariable(String variable) {
        return map.get(variable);
    }

}
