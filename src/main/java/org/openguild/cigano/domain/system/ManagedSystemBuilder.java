package org.openguild.cigano.domain.system;

import org.openguild.cigano.domain.assessment.AssessmentStrategy;
import org.openguild.cigano.domain.dimension.Dimension;
import org.openguild.cigano.domain.goal.Goal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagedSystemBuilder {

    private List<Dimension> dimensions = new ArrayList<>();

    private AssessmentStrategy assessmentStrategy = null;

    private Map<Integer, List<Goal>> priorityToGoals = new HashMap<>();


    public static ManagedSystemBuilder newBuilder() {
        return new ManagedSystemBuilder();
    }

    public ManagedSystemBuilder withDimension(Dimension dimension) {
        this.dimensions.add(dimension);
        return this;
    }


    public ManagedSystem build() {
        return new ManagedSystem(dimensions, priorityToGoals, assessmentStrategy);
    }

    public ManagedSystemBuilder withAssessmentStrategy(AssessmentStrategy assessmentStrategy) {
        this.assessmentStrategy = assessmentStrategy;
        return this;
    }

    public ManagedSystemBuilder withGoal(Integer priority, Goal goal) {
        if (!priorityToGoals.containsKey(priority)) {
            priorityToGoals.put(priority, new ArrayList<>());
        }
        priorityToGoals.get(priority).add(goal);
        return this;
    }
}
