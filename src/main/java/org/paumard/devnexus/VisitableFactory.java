package org.paumard.devnexus;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

@FunctionalInterface
public interface VisitableFactory<T> {

    Stream<Function<T, Object>> functions();

    default Visitable<T> makeVisitable(T t) {
        return () -> functions().map(function -> function.apply(t));
    }

    public static <T> X<T> forType(Class<T> type) {
        return () -> type;
    }

    @FunctionalInterface
    interface X<T> {

        Class<T> type();

        default VisitableFactory<T> visit(Function<T, Object>... functions) {
            return () -> Arrays.stream(functions);
        }
    }
}
