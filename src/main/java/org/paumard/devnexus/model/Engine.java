package org.paumard.devnexus.model;

import org.paumard.devnexus.Visitor;

public class Engine {

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Engine{}";
    }
}
