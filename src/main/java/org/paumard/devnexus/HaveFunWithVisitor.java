package org.paumard.devnexus;

import org.paumard.devnexus.model.Body;
import org.paumard.devnexus.model.Car;
import org.paumard.devnexus.model.Engine;
import org.paumard.devnexus.model.Wheel;

import java.util.List;
import java.util.stream.Collectors;

public class HaveFunWithVisitor {

    public static void main(String[] args) {

        Car renault = new Car();

//        VisitorInitializer<String> visitorInitializer =
//                builder -> {
//                    builder.register(Car.class, car -> "Visiting car: " + car);
//                    builder.register(Body.class, body -> "Visiting body: " + body);
//                    builder.register(Engine.class, engine -> "Visiting engine: " + engine);
//                    builder.register(Wheel.class, wheel -> "Visiting wheel: " + wheel);
//                };

        VisitorInitializer<String> visitorInitializer =
                Visitor.<Car, String>forType(Car.class).execute((Car car) -> "Visiting car: " + car)
                        .forType(Body.class).execute((Body body) -> "Visiting body: " + body)
                        .forType(Engine.class).execute(engine -> "Visiting engine: " + engine)
                        .forType(Wheel.class).execute(wheel -> "Visiting wheel: " + wheel);

        Visitor<String> visitor = Visitor.of(visitorInitializer);

        String visitedCar = visitor.visit(renault);
        System.out.println("visitedCar = " + visitedCar);

        String visitedBody = visitor.visit(renault.getBody());
        System.out.println("visitedBody = " + visitedBody);

        VisitableFactory<Car> visitableFactory =
                VisitableFactory.forType(Car.class)
                        .visit(
                                car -> car,
                                car -> car.getBody(),
                                car -> car.getEngine(),
                                car -> car.getWheels()[0]
                        );

        Visitable<Car> visitableRenaut = visitableFactory.makeVisitable(renault);

        String visited1 = visitableRenaut.accept(visitor, Collectors.joining("\n"));
        System.out.println("Visited car = " + visited1);

        List<String> visited2 = visitableRenaut.accept(visitor, Collectors.toList());
        System.out.println("Visited car = " + visited2);
    }

}
