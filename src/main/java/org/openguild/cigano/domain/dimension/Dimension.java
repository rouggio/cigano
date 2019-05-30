package org.openguild.cigano.domain.dimension;

import org.openguild.cigano.domain.value.ValueDomain;

public class Dimension {

    private String identifier;
    private ValueDomain valueDomain;

    public Dimension(String identifier, ValueDomain valueDomain) {
        this.identifier = identifier;
        this.valueDomain = valueDomain;
    }

    public String getIdentifier() {
        return identifier;
    }

    public ValueDomain getValueDomain() {
        return valueDomain;
    }
}
