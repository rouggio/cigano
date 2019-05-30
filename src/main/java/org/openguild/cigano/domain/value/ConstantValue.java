package org.openguild.cigano.domain.value;

public class ConstantValue implements ValueDomain {

    private int value;

    public ConstantValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
