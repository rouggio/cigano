package org.openguild.cigano.domain.system;

import org.openguild.cigano.domain.assessment.AssessmentStrategy;
import org.openguild.cigano.domain.dimension.Dimension;
import org.openguild.cigano.domain.goal.Goal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ManagedSystem {

    private List<Dimension> managedDimensions = new ArrayList<>();

    private Map<Integer, List<Goal>> priorityToGoals;

    private AssessmentStrategy assessmentStrategy;

    public ManagedSystem(List<Dimension> dimensions, Map<Integer, List<Goal>> priorityToGoals, AssessmentStrategy assessmentStrategy) {
        this.managedDimensions.addAll(dimensions);
        this.priorityToGoals = priorityToGoals;
        this.assessmentStrategy = assessmentStrategy;
    }

    public AssessmentStrategy getAssessmentStrategy() {
        return assessmentStrategy;
    }
}
