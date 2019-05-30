package org.openguild.cigano.domain.dimension;

import org.openguild.cigano.domain.value.ValueDomain;

public class ReadOnlyDimension extends Dimension {

    public ReadOnlyDimension(String identifier, ValueDomain valueDomain) {
        super(identifier, valueDomain);
    }

}
