package org.openguild.ai.q;

public class Scout {

    private int state;

    private Factor factor;

    public Scout(int initialState) {
        this.state = initialState;
    }

    public int getState() {
        return state;
    }

    public Factor getFactor() {
        return factor;
    }

    public void setFactor(Factor factor) {
        this.factor = factor;
    }

    public void explore() {
        exploreTrend(false);
        exploreTrend(true);
    }

    private void exploreTrend(boolean ascending) {
        int bestResult = factor.get(state);
        boolean progress;
        do {
            int result = attempt(ascending);
            if (result >= bestResult) {
                progress = true;
                bestResult = result;
            } else {
                progress = false;
            }
        } while (progress);
        attempt(!ascending);
    }

    private int attempt(boolean ascending) {
        int newState = ascending ? state + 1 : state - 1;
        if (factor.containsKey(newState)) {
            state = newState;
        }
        return factor.get(state);
    }
}
