package org.paumard.devnexus.model;

import org.paumard.devnexus.Visitor;

public class Wheel {

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Wheel{}";
    }
}
