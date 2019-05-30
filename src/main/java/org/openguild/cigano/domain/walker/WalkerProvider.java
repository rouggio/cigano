package org.openguild.cigano.domain.walker;

import org.openguild.cigano.domain.assessment.InstantAssessmentStrategy;
import org.openguild.cigano.domain.system.ManagedSystem;

public class WalkerProvider {

    private WalkerProvider() {
    }

    public static Walker findWalker(ManagedSystem managedSystem) {
        if (managedSystem.getAssessmentStrategy() == null) {
            throw new IllegalArgumentException("assessment strategy not set");
        } else if (managedSystem.getAssessmentStrategy() instanceof InstantAssessmentStrategy) {
            return new FiniteConvergenceWalker();
        } else {
            throw new IllegalArgumentException("unknown assessment strategy");
        }
    }

}
