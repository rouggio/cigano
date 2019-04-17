package org.openguild.ai.q;

import java.util.Set;

class Scout {

    private Exploreable exploreable;

    void setExploreable(Exploreable exploreable) {
        this.exploreable = exploreable;
    }

    void explore() {
        Set<String> dimensions = exploreable.getDimensions();
        for (String dimension : dimensions) {
            exploreTrend(dimension, false);
            exploreTrend(dimension, true);
        }
    }

    private void exploreTrend(String dimension, boolean ascending) {
        int bestResult = exploreable.getOutput();
        boolean progress;
        do {
            int result = attempt(dimension, ascending);
            if (result >= bestResult) {
                progress = true;
                bestResult = result;
            } else {
                progress = false;
            }
        } while (progress);
        attempt(dimension, !ascending);
    }

    private int attempt(String dimension, boolean ascending) {
        int dimensionValue = exploreable.getState(dimension);
        int newState = ascending ? dimensionValue + 1 : dimensionValue - 1;

        if (exploreable.admitsInput(dimension, newState)) {
            exploreable.setState(dimension, newState);
        }
        return exploreable.getOutput();
    }
}
