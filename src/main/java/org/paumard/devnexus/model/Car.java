package org.paumard.devnexus.model;

import org.paumard.devnexus.Visitor;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Car {

    private Body body = new Body();
    private Engine engine = new Engine();
    private Wheel[] wheels = {new Wheel(), new Wheel(), new Wheel(), new Wheel()};



//    public <R> R accept(Visitor<R> visitor) {
//        return visitor.visit(this);
//    }


//    public <R, RR> RR accept(Visitor<R> visitor, Collector<? super R, ?, RR> collector) {
//
//        R s1 = this.body.accept(visitor);
//        R s2 = this.engine.accept(visitor);
//        R s3 = this.wheels[0].accept(visitor);
//        R s4 = this.wheels[1].accept(visitor);
//        R s5 = this.wheels[2].accept(visitor);
//        R s6 = this.wheels[3].accept(visitor);
//
//        R s7 = accept(visitor);
//
//        return Stream.of(s1, s2, s3, s4, s5, s6, s7).collect(collector);
//    }

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
