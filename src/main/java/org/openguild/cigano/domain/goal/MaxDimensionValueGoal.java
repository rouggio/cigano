package org.openguild.cigano.domain.goal;

import org.openguild.cigano.domain.dimension.Dimension;

public class MaxDimensionValueGoal implements Goal {

    private Dimension dimension;

    public MaxDimensionValueGoal(Dimension dimension) {
        this.dimension = dimension;
    }
}
