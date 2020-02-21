package org.paumard.devnexus;

import java.util.stream.Collector;
import java.util.stream.Stream;

@FunctionalInterface
public interface Visitable<T> {

    Stream<Object> parts();

    default <R, RR> RR accept(Visitor<R> visitor, Collector<? super R, ?, RR> collector) {
        return parts().map(visitor::visit).collect(collector);
    }
}
