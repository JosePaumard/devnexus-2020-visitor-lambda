package org.paumard.devnexus;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@FunctionalInterface
public interface Visitor<R> {

    R visit(Object o);

    public static <R> Visitor<R> of(VisitorInitializer<R> visitorInitializer) {
        Map<Class<?>, Function<Object, R>> registry = new HashMap<>();
        visitorInitializer.init(registry::put);
        return o -> registry.get(o.getClass()).apply(o);
    }

    public static <T, R> X<T, R> forType(Class<T> type) {
        return () -> type;
    }

    @FunctionalInterface
    interface X<T, R> {

        Class<T> type();

        default Y<R> execute(Function<T, R> function) {
            return visitorBuilder -> visitorBuilder.register(type(), function.compose(type()::cast));
        }
    }

    @FunctionalInterface
    interface Y<R> extends VisitorInitializer<R> {

        default <T> Z<T, R> forType(Class<T> type) {
            return index -> index == 0 ? type : this;
        }

        default Y<R> andThen(Y<R> after) {
            return visitorBuilder -> { this.accept(visitorBuilder); after.accept(visitorBuilder);};
        }
    }

    @FunctionalInterface
    interface Z<T, R> {

        Object get(int index);

        default Y<R> previousInitializer() {
            return (Y<R>)get(1);
        }

        default Class<T> type() {
            return (Class<T>)get(0);
        }

        default Y<R> execute(Function<T, R> function) {
            return previousInitializer()
                    .andThen(
                            visitorBuilder ->
                                    visitorBuilder.register(type(), function.compose(type()::cast)));
        }
    }
}
