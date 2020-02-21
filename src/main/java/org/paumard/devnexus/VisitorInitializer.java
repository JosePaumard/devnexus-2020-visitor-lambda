package org.paumard.devnexus;

import java.util.function.Consumer;

@FunctionalInterface
public interface VisitorInitializer<R> extends Consumer<VisitorBuilder<R>> {

    default void init(VisitorBuilder<R> visitorBuilder) {
        this.accept(visitorBuilder);
    }
}
