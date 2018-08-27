package org.springsource.restbucks.order;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;

import javax.persistence.PostPersist;

/**
 * @author mucahitkurt
 * @since 26.08.2018
 */
public class OrderEntityListener {

    @PostPersist
    public void handleAfterCreate(Order order) {
        final Counter counter = Metrics.counter("entity.count", "type", "order");
        counter.increment();
    }
}
