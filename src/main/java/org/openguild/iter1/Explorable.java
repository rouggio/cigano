package org.openguild.iter1;

import java.util.Set;

public interface Explorable {

    int getState(String dimension);

    void setState(String dimension, int newState);

    Set<String> getDimensions();

    int getOutput();

    boolean admitsInput(String dimension, int key);

}
