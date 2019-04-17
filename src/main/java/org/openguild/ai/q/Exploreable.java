package org.openguild.ai.q;

import java.util.Set;

public interface Exploreable {

    int getState(String dimension);

    void setState(String dimension, int newState);

    Set<String> getDimensions();

    int getOutput();

    boolean admitsInput(String dimension, int key);

}
