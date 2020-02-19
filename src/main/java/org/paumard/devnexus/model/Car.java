package org.paumard.devnexus.model;

import org.paumard.devnexus.Visitor;

import java.util.Arrays;

public class Car {

    private Body body = new Body();
    private Engine engine = new Engine();
    private Wheel[] wheels = {new Wheel(), new Wheel(), new Wheel(), new Wheel()};



    public void accept(Visitor visitor) {
        this.body.accept(visitor);
        this.engine.accept(visitor);
        this.wheels[0].accept(visitor);
        this.wheels[1].accept(visitor);
        this.wheels[2].accept(visitor);
        this.wheels[3].accept(visitor);
        visitor.visit(this);
    }

    public Body getBody() {
        return body;
    }

    public Engine getEngine() {
        return engine;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    @Override
    public String toString() {
        return "Car{" +
                "body=" + body +
                ", engine=" + engine +
                ", wheels=" + Arrays.toString(wheels) +
                '}';
    }
}
