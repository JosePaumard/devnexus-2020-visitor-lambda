package org.paumard.devnexus;

import java.util.function.BiConsumer;
import java.util.function.Function;

@FunctionalInterface
public interface VisitorBuilder<R> extends BiConsumer<Class<?>, Function<Object, R>> {

    default void register(Class<?> type, Function<Object, R> function) {
        this.accept(type, function);
    }
}
