package org.openguild.cigano;

import java.util.Set;

class Scout {

    private Explorable explorable;

    void setExplorable(Explorable explorable) {
        this.explorable = explorable;
    }

    void explore() {
        Set<String> dimensions = explorable.getDimensions();
        for (String dimension : dimensions) {
            exploreTrend(dimension, false);
            exploreTrend(dimension, true);
        }
    }

    private void exploreTrend(String dimension, boolean ascending) {
        int bestResult = explorable.getOutput();
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
        int dimensionValue = explorable.getState(dimension);
        int newState = ascending ? dimensionValue + 1 : dimensionValue - 1;

        if (explorable.admitsInput(dimension, newState)) {
            explorable.setState(dimension, newState);
        }
        return explorable.getOutput();
    }
}
