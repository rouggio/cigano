package org.openguild.cigano.domain.dimension;

import org.openguild.cigano.domain.value.IntegerRange;

public class ManagedDimension extends Dimension {

    private Integer state;

    public ManagedDimension(String identifier, IntegerRange integerRange) {
        super(identifier, integerRange);
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
