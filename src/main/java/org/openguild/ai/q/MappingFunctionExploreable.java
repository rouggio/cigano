package org.openguild.ai.q;

import java.util.*;

public class MappingFunctionExploreable implements Exploreable {

    private Map<String, Integer> state = new HashMap<>();

    private Set<String> dimensions = new HashSet<>();

    private Map<String, Map<Integer, Integer>> dimensionToMappingFunction = new HashMap<>();

    MappingFunctionExploreable(String... dimensions) {
        this.dimensions.addAll(Arrays.asList(dimensions));
    }

    void addData(String state, int key, int value) {
        if (!dimensionToMappingFunction.containsKey(state)) {
            dimensionToMappingFunction.put(state, new HashMap<>());
        }
        Map<Integer, Integer> mappingFunction = dimensionToMappingFunction.get(state);
        mappingFunction.put(key, value);
    }

    @Override
    public int getState(String dimension) {
        return state.get(dimension);
    }

    @Override
    public void setState(String dimension, int newState) {
        this.state.put(dimension, newState);
    }

    @Override
    public Set<String> getDimensions() {
        return dimensions;
    }

    @Override
    public int getOutput() {
        int overall = 1;
        for (String dimension : dimensions) {
            Map<Integer, Integer> mappingFunction = dimensionToMappingFunction.get(dimension);
            overall *= mappingFunction.get(state.get(dimension));
        }
        return overall;
    }

    @Override
    public boolean admitsInput(String dimension, int key) {
        Map<Integer, Integer> mappingFunction = dimensionToMappingFunction.get(dimension);
        return mappingFunction.containsKey(key);
    }
}
