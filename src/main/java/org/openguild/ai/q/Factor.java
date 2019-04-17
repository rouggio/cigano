package org.openguild.ai.q;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Factor {

    private Map<Integer, Integer> mappingFunction = new HashMap<>();

    public Factor(int[][] tuple) {
        for (int[] ints : tuple) {
            mappingFunction.put(ints[0], ints[1]);
        }
    }

    public void setMappingFunction(Map<Integer, Integer> mappingFunction) {
        this.mappingFunction = mappingFunction;
    }

    public Map<Integer, Integer> getMappingFunction() {
        return mappingFunction;
    }

    public int get(int key) {
        return mappingFunction.get(key);
    }

    public boolean containsKey(int key) {
        return mappingFunction.containsKey(key);
    }
}
