package org.openguild.cigano;

import org.junit.Test;
import org.openguild.cigano.domain.assessment.InstantAssessmentStrategy;
import org.openguild.cigano.domain.dimension.ManagedDimension;
import org.openguild.cigano.domain.dimension.ReadOnlyDimension;
import org.openguild.cigano.domain.goal.MaxDimensionValueGoal;
import org.openguild.cigano.domain.knowledge.Knowledge;
import org.openguild.cigano.domain.system.ManagedSystem;
import org.openguild.cigano.domain.system.ManagedSystemBuilder;
import org.openguild.cigano.domain.value.ConstantValue;
import org.openguild.cigano.domain.value.FunctionalValue;
import org.openguild.cigano.domain.value.IntegerRange;
import org.openguild.cigano.domain.walker.FiniteConvergenceWalker;
import org.openguild.cigano.domain.walker.Walker;
import org.openguild.cigano.domain.walker.WalkerProvider;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CiganoTests {

    @Test
    public void testDimensions() {

        // setting up dimensions
        ReadOnlyDimension airPressureDimension = new ReadOnlyDimension("air_pressure", new ConstantValue(1000));

        ManagedDimension advanceDimension = new ManagedDimension("advance",
                new IntegerRange(-40, 0)
        );

        ReadOnlyDimension rpmsDimension = new ReadOnlyDimension("rpm", new FunctionalValue() {
            @Override
            public int getValue() {
                // 2000 rpms at -20 degrees, 10 rpm decreases at each degree off either side
                return 2000 - ((-20 - advanceDimension.getState()) * 10);
            }
        });

        // wrap up entire system
        ManagedSystem managedSystem = ManagedSystemBuilder.newBuilder()
                .withDimension(airPressureDimension)
                .withDimension(advanceDimension)
                .withDimension(rpmsDimension)
                .withAssessmentStrategy(new InstantAssessmentStrategy())
                .withGoal(1, new MaxDimensionValueGoal(rpmsDimension))
                .build();

        // obtain an appropriate walker
        Walker walker = WalkerProvider.findWalker(managedSystem);
        assertTrue(walker instanceof FiniteConvergenceWalker);
        FiniteConvergenceWalker finiteConvergenceWalker = (FiniteConvergenceWalker) walker;

        // acquire knowledge off system
        Knowledge knowledge = finiteConvergenceWalker.exploreFull();

        // obtain expected result
        assertEquals(-20, knowledge.getScalar("advance"));
    }
}