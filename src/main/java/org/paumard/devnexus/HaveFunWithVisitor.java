package org.paumard.devnexus;

import org.paumard.devnexus.model.Body;
import org.paumard.devnexus.model.Car;
import org.paumard.devnexus.model.Engine;
import org.paumard.devnexus.model.Wheel;

public class HaveFunWithVisitor {

    public static void main(String[] args) {

        Car renault = new Car();

        Visitor visitor = new Visitor() {

            String visited = "";

            public void visit(Car car) {
                visited += "Visiting car: " + car;
            }

            public void visit(Body body) {
                visited += "Visiting body: " + body;
            }

            public void visit(Engine engine) {
                visited += "Visiting engine: " + engine;
            }

            public void visit(Wheel wheel) {
                visited += "Visiting wheel: " + wheel;
            }

            public String getVisited() {
                return this.visited;
            }
        };

        renault.accept(visitor);
        System.out.println("Visited car = " + visitor.getVisited());
    }
}
