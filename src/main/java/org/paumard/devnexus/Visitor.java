package org.paumard.devnexus;

import org.paumard.devnexus.model.Body;
import org.paumard.devnexus.model.Car;
import org.paumard.devnexus.model.Engine;
import org.paumard.devnexus.model.Wheel;

public interface Visitor {

    void visit(Car car);

    void visit(Body body);

    void visit(Engine engine);

    void visit(Wheel wheel);
}
